package id.co.astratech.astra.service;

import id.co.astratech.astra.model.*;
import id.co.astratech.astra.repository.*;
import id.co.astratech.astra.response.DtoResponse;
import id.co.astratech.astra.vo.DetailTransaksiVo;
import id.co.astratech.astra.vo.TransaksiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TransaksiCustService {
    @Autowired
    private TransaksiCustRepository transaksiCustRepository;

    @Autowired
    private DetailCustRepository detailCustRepository;

    @Autowired
    private DurasiRepository durasiRepository;

    @Autowired
    private AlamatRepository alamatRepository;

    @Autowired
    private UserRepository userRepository;

    public DtoResponse getAllTransaksiByStatus(String status){
            Iterable<Transaksi> transaksis = transaksiCustRepository.getAllTransaksiByStatus(status);
            List<TransaksiVo> transaksiVos = new ArrayList<>();

            for (Transaksi item: transaksis){
                TransaksiVo transaksiVo = new TransaksiVo(item);
                User user = userRepository.findById(transaksiVo.getIdUser()).orElse(null);
                transaksiVo.setNamaUser(user.getNamaUser());
                transaksiVo.setNoTelp(user.getNoTelp());
                Durasi durasi = durasiRepository.findById(transaksiVo.getIdDurasi()).orElse(null);
                transaksiVo.setNamaDurasi(durasi.getNamaDurasi());
                Alamat alamat = alamatRepository.findById(transaksiVo.getIdAlamat()).orElse(null);
                transaksiVo.setNamaAlamat(alamat.getNamaAlamat());
                transaksiVo.setLongitude(alamat.getLongtitude());
                transaksiVo.setLatitude(alamat.getLatitude());
                transaksiVos.add(transaksiVo);
            }
            return new DtoResponse(200, transaksiVos, "Data Di temukan");
    }

    public DtoResponse getTransaksiByIdAndStatus(Integer idUser, String status){
        User userDB = userRepository.findById(idUser).orElse(null);

        if(userDB != null){
            Iterable<Transaksi> transaksis = transaksiCustRepository.getTransaksiByIdAndStatus(idUser, status);
            List<TransaksiVo> transaksiVos = new ArrayList<>();

            for (Transaksi item: transaksis){
                TransaksiVo transaksiVo = new TransaksiVo(item);
//                Date tanggalPesanan = item.getTanggal_pesanan();
//                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S", Locale.getDefault());
//                SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
//                try{
//                    String tanggalString = outputFormat.format(inputFormat.parse(tanggalPesanan.toString()));
//                    transaksiVo.setTanggalPesanan(tanggalString);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
                transaksiVos.add(transaksiVo);
            }
            return new DtoResponse(200, transaksiVos, "Data Di temukan");
        }else if(userDB == null) {
            return new DtoResponse(404, null, "Data User tidak di temukan");
        }else {
            return new DtoResponse(500, null, "Terjadi Kesalahan saat mengambil data");
        }
    }

    public DtoResponse getTransaksiById(Integer idUser){
        User userDB = userRepository.findById(idUser).orElse(null);

        if(userDB != null){
            Iterable<Transaksi> transaksis = transaksiCustRepository.getTransaksiById(idUser);
            List<TransaksiVo> transaksiVos = new ArrayList<>();

            for (Transaksi item: transaksis){
                TransaksiVo transaksiVo = new TransaksiVo(item);
//                Date tanggalPesanan = item.getTanggal_pesanan();
//                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S", Locale.getDefault());
//                SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
//                try{
//                    String tanggalString = outputFormat.format(inputFormat.parse(tanggalPesanan.toString()));
//                    transaksiVo.setTanggalPesanan(tanggalString);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
                transaksiVos.add(transaksiVo);
            }
            return new DtoResponse(200, transaksiVos, "Data Di temukan");
        }else if(userDB == null) {
            return new DtoResponse(404, null, "Data User tidak di temukan");
        }else {
            return new DtoResponse(500, null, "Terjadi Kesalahan saat mengambil data");
        }
    }

    public DtoResponse getTransaksiDetail(Integer idTransaksi){
        Transaksi transaksiDB = transaksiCustRepository.findById(idTransaksi).orElse(null);

        if(transaksiDB != null){
            List<DetailTransaksi> detailTransaksis = detailCustRepository.getDetailTransaksi(idTransaksi);
            List<DetailTransaksiVo> detailTransaksiVos = new ArrayList<>();

            for (DetailTransaksi item: detailTransaksis){
                DetailTransaksiVo detailTransaksiVo = new DetailTransaksiVo(item);
                detailTransaksiVos.add(detailTransaksiVo);
            }
            return new DtoResponse(200, detailTransaksiVos, "Data Di temukan");
        }else if(transaksiDB == null) {
            return new DtoResponse(404, null, "Data User tidak di temukan");
        }else {
            return new DtoResponse(500, null, "Terjadi Kesalahan saat mengambil data");
        }
    }

    public DtoResponse saveTransaksiCust(TransaksiVo transaksiVo){
        try {
            User existingUser = userRepository.findById(transaksiVo.getIdUser()).orElse(null);
            Durasi existingDurasi = durasiRepository.findById(transaksiVo.getIdDurasi()).orElse(null);

            if(existingUser != null & existingDurasi != null){
                Transaksi data = new Transaksi();

                Integer lamaDurasi = existingDurasi.getLamaDurasi();
                Integer hargaDurasi = existingDurasi.getHargaDurasi();

                Calendar cal = Calendar.getInstance();
                cal.setTime(transaksiVo.getTanggalPesanan());
                // Menambahkan jumlah hari dari durasi
                cal.add(Calendar.DAY_OF_MONTH, lamaDurasi);
                // Mendapatkan tanggal baru setelah penambahan hari
                Date tanggalBaru = cal.getTime();

                data.setId_transaksi(transaksiVo.getIdTransaksi());
                data.setId_durasi(transaksiVo.getIdDurasi());
                data.setId_alamat(transaksiVo.getIdAlamat());
                data.setId_user(transaksiVo.getIdUser());
                data.setTanggal_pesanan(transaksiVo.getTanggalPesanan());
                data.setStatus_pesanan("Pick Up");
                data.setStatus_pembayaran("Belum Bayar");
                data.setTanggal_pengiriman(tanggalBaru);
                data.setOngkir(transaksiVo.getOngkir());
                data.setTotal_harga(transaksiVo.getOngkir());
                Transaksi saveData = transaksiCustRepository.save(data);
                return new DtoResponse(200, transaksiVo, "Sukses Membuat Data");
            }else {
                return new DtoResponse(404, null, "Alamat Tidak di temukan");
            }

        }catch (Exception e){
            return new DtoResponse(500, null,"Terjadi saat menambahkan data " + e.getMessage());
        }
    }

    public DtoResponse batalkanTrsKurir(Integer idTransaksi, String catatan) {
        try {
            // Mengambil data yang ada dari database
            Transaksi existingTransaksi = transaksiCustRepository.findById(idTransaksi).orElse(null);

            // Periksa apakah ada di dalam database atau tidak
            if (existingTransaksi == null) {
                return new DtoResponse(404, null, "Data Transaksi tidak ditemukan");
            }

            // Lakukan Update sesuai dengan field yang terupdate
            existingTransaksi.setCatatan(catatan);
            Transaksi updatedTransaksi = transaksiCustRepository.save(existingTransaksi);

            return new DtoResponse(200, updatedTransaksi, "Data transaksi berhasil diupdate");

        } catch (Exception e) {
            return new DtoResponse(500, null, "Gagal mengupdate data transaksi");
        }
    }

    public DtoResponse getTotalHarga(Integer idTransaksi){
        Transaksi transaksiDB = transaksiCustRepository.findById(idTransaksi).orElse(null);

        if(transaksiDB != null){
            List<Transaksi> transaksis = transaksiCustRepository.getTotalHarga(idTransaksi);
            List<TransaksiVo> transaksiVos = new ArrayList<>();

            for (Transaksi item: transaksis){
                TransaksiVo transaksiVo = new TransaksiVo(item);
                transaksiVos.add(transaksiVo);
            }
            return new DtoResponse(200, transaksiVos, "Data Di temukan");
        }else if(transaksiDB == null) {
            return new DtoResponse(404, null, "Data User tidak di temukan");
        }else {
            return new DtoResponse(500, null, "Terjadi Kesalahan saat mengambil data");
        }
    }
}
