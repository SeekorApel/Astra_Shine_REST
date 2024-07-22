package id.co.astratech.astra.service;

import id.co.astratech.astra.model.User;
import id.co.astratech.astra.repository.UserRepository;
import id.co.astratech.astra.response.DtoResponse;
import id.co.astratech.astra.vo.LoginVo;
import org.json.JSONException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import java.security.SecureRandom;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender mailSender;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    private static final String API_KEY = "0WZ4K5RX1ZSCRJIONUZ9"; // API key Anda
    private static final String API_URL = "https://api.mailboxvalidator.com/v1/validation/single?key=" + API_KEY + "&email=";

    public DtoResponse registerUser(User user) {
        try {

            int statusEmail = checkExistingEmail(user.getEmail());
            if (statusEmail == 0) {
                return new DtoResponse(500, null, "Email Tidak Valid");
            }

            String existingEmail = checkEmail(user.getEmail());
            if (user.getEmail().equals(existingEmail)) {
                return new DtoResponse(500, null, "Email Sudah di Gunakan");
            }

            User newData = new User();
            newData.setEmail(user.getEmail());
            newData.setPassword(user.getPassword());
            newData.setNamaUser(user.getNamaUser());
            newData.setNoTelp(user.getNoTelp());
            newData.setRole("Customer");
            newData.setStatus("Aktif");
            userRepository.save(newData);
            return new DtoResponse(200, user, "Sukses Registrasi Akun");

        } catch (Exception e) {
            return new DtoResponse(500, user, "Terjadi Kesalahan saat menambah data " + e.getMessage());
        }
    }

    public DtoResponse getUserByEmailAndPassword(String email, String password) {
        User user = userRepository.findUserByEmailAndPassword(email, password);
        if (user != null) {
            LoginVo loginVo = new LoginVo(user);
            return new DtoResponse(200, loginVo, "Login Sukses");
        } else {
            return new DtoResponse(404, null, "Data User tidak di temukan");
        }
    }

    public String checkEmail(String submittedEmail) {
        return userRepository.getExistingEmail(submittedEmail);
    }

    // Method untuk membuat string acak
    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    public DtoResponse resetPasswordByEmail(String email) {

        int statusEmail = checkExistingEmail(email);
        if (statusEmail == 0) {
            return new DtoResponse(500, null, "Email Tidak Valid");
        }

        //Generate Temp Password
        String temporaryPassword = generateRandomString(12);

        User userDB = userRepository.findUserByEmail(email);
        User user = new User();

        //Copy semua property dari userDB
        BeanUtils.copyProperties(userDB, user);
        user.setPassword(temporaryPassword);

        //Mengupdate data password baru
        userRepository.save(user);

        CompletableFuture.runAsync(() -> {
            String bodyEmail = createBodyEmail(temporaryPassword, user.getNamaUser(), user.getEmail());
            createEmail(email, "Reset Password", bodyEmail);
        });

        return new DtoResponse(200, null, "Password baru sudah dikirim ke email Anda");
    }

    public DtoResponse resetPasswordByTempPassword(Integer idUser, String newPassword, String oldPassword) {
        User userDB = userRepository.findById(idUser).orElse(null);
        try {
            if (userDB != null) {
                if (!userDB.getPassword().equals(oldPassword)) {
                    return new DtoResponse(500, userDB, "Password lama tidak sesuai");
                }
            }
            User user = new User();
            BeanUtils.copyProperties(userDB, user);
            user.setPassword(newPassword);
            User updatePassword = userRepository.save(user);
            return new DtoResponse(200, updatePassword, "Sukses mengubah password anda");

        } catch (Exception e) {
            return new DtoResponse(500, null, e.getMessage());
        }
    }

    @Async
    public void createEmail(String toEmail,
                            String subject,
                            String body) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sisteminformasiperwalian@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
    }

    private String createBodyEmail(String newPassword, String namaUser, String emailUser) {
        return String.format("Halo %s,\n\n"
                        + "Kami telah menerima permintaan untuk mengatur ulang kata sandi akun Anda. Berikut adalah informasi kata sandi baru Anda:\n\n"
                        + "Email Pengguna: %s\n"
                        + "Kata Sandi Baru: %s\n\n"
                        + "Silakan gunakan kata sandi ini untuk masuk ke akun Anda. Demi keamanan akun Anda, harap segera mengganti kata sandi setelah login pertama.",
                namaUser, emailUser, newPassword);
    }

    public static int checkExistingEmail(String email) {
        return isEmailExists(email) ? 1 : 0;
    }

    private static boolean isEmailExists(String email) {
        try {
            String urlString = API_URL + email;
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // Check if the request was successful
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                return false; // Jika tidak berhasil, anggap email tidak ada
            }

            // Parse response
            Scanner sc = new Scanner(url.openStream());
            StringBuilder inline = new StringBuilder();
            while (sc.hasNext()) {
                inline.append(sc.nextLine());
            }
            sc.close();

            // Convert the string response to JSON
            JSONObject jsonResponse = new JSONObject(inline.toString());

            // Check the status
            return jsonResponse.optBoolean("is_verified", false);

        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

}
