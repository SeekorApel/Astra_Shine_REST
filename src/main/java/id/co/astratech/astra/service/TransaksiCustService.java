package id.co.astratech.astra.service;

import id.co.astratech.astra.model.*;
import id.co.astratech.astra.repository.DetailCustRepository;
import id.co.astratech.astra.repository.DurasiRepository;
import id.co.astratech.astra.repository.TransaksiCustRepository;
import id.co.astratech.astra.repository.UserRepository;
import id.co.astratech.astra.response.DtoResponse;
import id.co.astratech.astra.vo.DetailTransaksiVo;
import id.co.astratech.astra.vo.TransaksiVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TransaksiCustService {
    @Autowired
    private TransaksiCustRepository transaksiCustRepository;

    @Autowired
    private DetailCustRepository detailCustRepository;

    @Autowired
    private DurasiRepository durasiRepository;

    @Autowired
    private UserRepository userRepository;

    public DtoResponse getTransaksiPickUp(Integer idUser){
        User userDB = userRepository.findById(idUser).orElse(null);

        if(userDB != null){
            Iterable<Transaksi> transaksis = transaksiCustRepository.getTransaksiPickup(idUser);
            List<TransaksiVo> transaksiVos = new ArrayList<>();

            for (Transaksi item: transaksis){
                TransaksiVo transaksiVo = new TransaksiVo(item);
                transaksiVos.add(transaksiVo);
            }
            return new DtoResponse(200, transaksiVos, "Data Di temukan");
        }else if(userDB == null) {
            return new DtoResponse(404, null, "Data User tidak di temukan");
        }else {
            return new DtoResponse(500, null, "Terjadi Kesalahan saat mengambil data");
        }
    }

    public DtoResponse getTransaksiProses(Integer idUser){
        User userDB = userRepository.findById(idUser).orElse(null);

        if(userDB != null){
            Iterable<Transaksi> transaksis = transaksiCustRepository.getTransaksiProses(idUser);
            List<TransaksiVo> transaksiVos = new ArrayList<>();

            for (Transaksi item: transaksis){
                TransaksiVo transaksiVo = new TransaksiVo(item);
                transaksiVos.add(transaksiVo);
            }
            return new DtoResponse(200, transaksiVos, "Data Di temukan");
        }else if(userDB == null) {
            return new DtoResponse(404, null, "Data User tidak di temukan");
        }else {
            return new DtoResponse(500, null, "Terjadi Kesalahan saat mengambil data");
        }
    }

    public DtoResponse getTransaksiSelesai(Integer idUser){
        User userDB = userRepository.findById(idUser).orElse(null);

        if(userDB != null){
            Iterable<Transaksi> transaksis = transaksiCustRepository.getTransaksiSelesai(idUser);
            List<TransaksiVo> transaksiVos = new ArrayList<>();

            for (Transaksi item: transaksis){
                TransaksiVo transaksiVo = new TransaksiVo(item);
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

                Date tanggalPesanan = transaksiVo.getTanggalPesanan();
                Calendar cal = Calendar.getInstance();
                cal.setTime(tanggalPesanan);
                // Menambahkan jumlah hari dari durasi
                cal.add(Calendar.DAY_OF_MONTH, lamaDurasi);
                // Mendapatkan tanggal baru setelah penambahan hari
                Date tanggalBaru = cal.getTime();

                data.setId_transaksi(transaksiVo.getIdTransaksi());
                data.setId_durasi(transaksiVo.getIdDurasi());
                data.setId_alamat(transaksiVo.getIdAlamat());
                data.setId_user(transaksiVo.getIdUser());
                data.setTanggal_pesanan(tanggalPesanan);
                data.setStatus_pesanan("Pick Up");
                data.setStatus_pembayaran("Belum Bayar");
                data.setTanggal_pengiriman(tanggalBaru);
                data.setTotal_harga(hargaDurasi);
                System.out.println("kk");
                Transaksi saveData = transaksiCustRepository.save(data);
                return new DtoResponse(200, transaksiVo, "Sukses Membuat Data");
            }else {
                return new DtoResponse(404, null, "Alamat Tidak di temukan");
            }

        }catch (Exception e){
            return new DtoResponse(500, null,"Terjadi saat menambahkan data " + e.getMessage());
        }
    }
}
