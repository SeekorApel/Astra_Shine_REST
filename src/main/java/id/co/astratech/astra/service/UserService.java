package id.co.astratech.astra.service;

import id.co.astratech.astra.model.User;
import id.co.astratech.astra.repository.UserRepository;
import id.co.astratech.astra.response.DtoResponse;
import id.co.astratech.astra.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public DtoResponse registerUser(User user){
        try {
            User newData = new User();
            newData.setEmail(user.getEmail());
            newData.setPassword(user.getPassword());
            newData.setNamaUser(user.getNamaUser());
            newData.setNoTelp(user.getNoTelp());
            newData.setRole("Customer");
            newData.setStatus("Aktif");

            userRepository.save(newData);
            return new DtoResponse(200,user,"Sukses Membuat Data");
        }catch (Exception e){
            return new DtoResponse(500,user,"Terjadi Kesalahan saat menambah data " + e.getMessage());
        }
    }

    public DtoResponse getUserByEmailAndPassword(String email, String password){
        User user = userRepository.findUserByEmailAndPassword(email, password);
        if(user != null){
            LoginVo loginVo = new LoginVo(user);
            return new DtoResponse(200, loginVo, "Sukses");
        }else {
            return new DtoResponse(404, null, "Data User tidak di temukan");
        }
    }

}
