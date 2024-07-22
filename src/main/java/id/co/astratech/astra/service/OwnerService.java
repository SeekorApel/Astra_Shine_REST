package id.co.astratech.astra.service;

import id.co.astratech.astra.model.*;
import id.co.astratech.astra.repository.*;
import id.co.astratech.astra.response.DtoResponse;
import id.co.astratech.astra.vo.DetailTransaksiVo;
import id.co.astratech.astra.vo.TransaksiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private DetailCustRepository detailCustRepository;

    @Autowired
    private LayananRepository layananRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DurasiRepository durasiRepository;

    @Autowired
    private AlamatRepository alamatRepository;

    public DtoResponse getAllTrsOwner(){
        Iterable<Transaksi> durasi = ownerRepository.findAll();
        List<TransaksiVo> transaksiVos = new ArrayList<>();

        for (Transaksi trsansaksi: durasi){
            TransaksiVo transaksiVo = new TransaksiVo(trsansaksi);
            User user = userRepository.findById(transaksiVo.getIdUser()).orElse(null);
            transaksiVo.setNamaUser(user.getNamaUser());
            transaksiVos.add(transaksiVo);
        }
        return new DtoResponse(200, transaksiVos, "Data Di temukan");
    }

    public DtoResponse getDetailTransaksi(Integer idTransaksi){
        Transaksi transaksiDB = ownerRepository.findById(idTransaksi).orElse(null);

        if(transaksiDB != null){
            List<DetailTransaksi> detailTransaksis = detailCustRepository.getDetailTransaksi(idTransaksi);
            List<DetailTransaksiVo> detailTransaksiVos = new ArrayList<>();

            for (DetailTransaksi item: detailTransaksis){
                DetailTransaksiVo detailTransaksiVo = new DetailTransaksiVo(item);
                Layanan layanan = layananRepository.findById(detailTransaksiVo.getIdLayanan()).orElse(null);
                detailTransaksiVos.add(detailTransaksiVo);
            }
            return new DtoResponse(200, detailTransaksiVos, "Data Di temukan");
        }else if(transaksiDB == null) {
            return new DtoResponse(404, null, "Data User tidak di temukan");
        }else {
            return new DtoResponse(500, null, "Terjadi Kesalahan saat mengambil data");
        }
    }

    public DtoResponse getTrsById(Integer idTransaksi){
        Transaksi transaksiDB = ownerRepository.findById(idTransaksi).orElse(null);

        if(transaksiDB != null){
            Iterable<Transaksi> trs = ownerRepository.getTrsById(idTransaksi);
            List<TransaksiVo> transaksiVos = new ArrayList<>();

            for (Transaksi trsansaksi: trs){
                TransaksiVo transaksiVo = new TransaksiVo(trsansaksi);

                User user = userRepository.findById(transaksiVo.getIdUser()).orElse(null);
                transaksiVo.setNamaUser(user.getNamaUser());
                transaksiVo.setNoTelp(user.getNoTelp());
                Durasi durasi = durasiRepository.findById(transaksiVo.getIdDurasi()).orElse(null);
                transaksiVo.setNamaDurasi(durasi.getNamaDurasi());
                Alamat alamat = alamatRepository.findById(transaksiVo.getIdAlamat()).orElse(null);
                transaksiVo.setNamaAlamat(alamat.getNamaAlamat());

                transaksiVos.add(transaksiVo);
            }
            return new DtoResponse(200, transaksiVos, "Data Di temukan");
        }else if(transaksiDB == null) {
            return new DtoResponse(404, null, "Data User tidak di temukan");
        }else {
            return new DtoResponse(500, null, "Terjadi Kesalahan saat mengambil data");
        }
    }

    public DtoResponse getDtlById(Integer idTransaksi){
        Transaksi transaksiDB = ownerRepository.findById(idTransaksi).orElse(null);

        if(transaksiDB != null){
            List<DetailTransaksi> detailTransaksis = detailCustRepository.getDetailTransaksi(idTransaksi);
            List<DetailTransaksiVo> detailTransaksiVos = new ArrayList<>();

            for (DetailTransaksi item: detailTransaksis){
                DetailTransaksiVo detailTransaksiVo = new DetailTransaksiVo(item);

                Layanan layanan = layananRepository.findById(detailTransaksiVo.getIdLayanan()).orElse(null);
                detailTransaksiVo.setNamaLayanan(layanan.getNamaLayanan());

                detailTransaksiVos.add(detailTransaksiVo);
            }
            return new DtoResponse(200, detailTransaksiVos, "Data Di temukan");
        }else if(transaksiDB == null) {
            return new DtoResponse(404, null, "Data Transaksi tidak di temukan");
        }else {
            return new DtoResponse(500, null, "Terjadi Kesalahan saat mengambil data");
        }
    }

    public DtoResponse updateTransaksi(Integer idTransaksi, String status_pesanan) {
        try {
            // Mengambil data yang ada dari database
            Transaksi existingTransaksi = ownerRepository.findById(idTransaksi).orElse(null);

            // Periksa apakah ada di dalam database atau tidak
            if (existingTransaksi == null) {
                return new DtoResponse(404, null, "Data Transaksi tidak ditemukan");
            }

            // Lakukan Update sesuai dengan field yang terupdate
            existingTransaksi.setStatus_pesanan(status_pesanan);
            Transaksi updatedTransaksi = ownerRepository.save(existingTransaksi);

            return new DtoResponse(200, updatedTransaksi, "Data transaksi berhasil diupdate");

        } catch (Exception e) {
            return new DtoResponse(500, null, "Gagal mengupdate data transaksi");
        }
    }
}
