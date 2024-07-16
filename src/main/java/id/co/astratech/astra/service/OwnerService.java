package id.co.astratech.astra.service;

import id.co.astratech.astra.model.DetailTransaksi;
import id.co.astratech.astra.model.Layanan;
import id.co.astratech.astra.model.Transaksi;
import id.co.astratech.astra.repository.DetailCustRepository;
import id.co.astratech.astra.repository.LayananRepository;
import id.co.astratech.astra.repository.OwnerRepository;
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

    public DtoResponse getAllTrsOwner(){
        Iterable<Transaksi> durasi = ownerRepository.findAll();
        List<TransaksiVo> transaksiVos = new ArrayList<>();

        for (Transaksi trsansaksi: durasi){
            TransaksiVo transaksiVo = new TransaksiVo(trsansaksi);
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
