package id.co.astratech.astra.service;

import id.co.astratech.astra.model.*;
import id.co.astratech.astra.repository.DetailCustRepository;
import id.co.astratech.astra.repository.LayananRepository;
import id.co.astratech.astra.repository.TransaksiCustRepository;
import id.co.astratech.astra.repository.UserRepository;
import id.co.astratech.astra.response.DtoResponse;
import id.co.astratech.astra.vo.DetailTransaksiVo;
import id.co.astratech.astra.vo.TransaksiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetailTransaksiService {
    @Autowired
    private TransaksiCustRepository transaksiCustRepository;

    @Autowired
    private DetailCustRepository detailCustRepository;

    @Autowired
    private LayananRepository layananRepository;

    public DtoResponse saveDetailTransaksi(DetailTransaksiVo detailTransaksiVo) {
        try{

            //Validasi check id di dalam database
            Layanan existingProduk = layananRepository.findById(detailTransaksiVo.getIdLayanan()).orElse(null);
            Transaksi existingTransaksiId = transaksiCustRepository.findById(detailTransaksiVo.getIdTransaksi()).orElse(null);

            if(existingProduk == null){
                return new DtoResponse(404,null, "Layanan Tidak di temukan");
            }

            if(existingTransaksiId == null){
                return new DtoResponse(404, null, "IDTransaksi Tidak di temukan");
            }

            //Set ID PK
            DetailTransaksiPK detailTransaksiPK = new DetailTransaksiPK();
            detailTransaksiPK.setId_transaksi(detailTransaksiVo.getIdTransaksi());
            detailTransaksiPK.setId_layanan(detailTransaksiVo.getIdLayanan());

            //Save Detail
            DetailTransaksi detailTransaksi = new DetailTransaksi();
            detailTransaksi.setDetailTransaksiPK(detailTransaksiPK);
            detailTransaksi.setQty(detailTransaksiVo.getQty());

            DetailTransaksi saveData = detailCustRepository.save(detailTransaksi);

            if(saveData !=null){
                existingTransaksiId.setStatus_pesanan("Proses");
                transaksiCustRepository.save(existingTransaksiId);
            }

            return new DtoResponse(200, saveData, "Detail Transaksi Berhasil disimpan");

        }catch (Exception e){
            return new DtoResponse(500, detailTransaksiVo, "Detail Transaksi Gagal disimpan");
        }
    }
    public DtoResponse statusPembayaran(Integer idTransaksi) {
        try{
            Transaksi existingTransaksiId = transaksiCustRepository.findById(idTransaksi).orElse(null);
            if(existingTransaksiId == null){
                return new DtoResponse(404, null, "IDTransaksi Tidak di temukan");
            }
            existingTransaksiId.setStatus_pembayaran("Sudah Bayar");
            Transaksi saveData = transaksiCustRepository.save(existingTransaksiId);

            return new DtoResponse(200, saveData, "Pembayaran Berhasil");

        }catch (Exception e){
            return new DtoResponse(500, null, "Pembayaran Gagal");
        }
    }
    public DtoResponse batalTransaksi(Integer idTransaksi,String catatan) {
        try{
            Transaksi existingTransaksiId = transaksiCustRepository.findById(idTransaksi).orElse(null);
            if(existingTransaksiId == null){
                return new DtoResponse(404, null, "IDTransaksi Tidak di temukan");
            }
            existingTransaksiId.setCatatan(catatan);
            Transaksi saveData = transaksiCustRepository.save(existingTransaksiId);

            return new DtoResponse(200, saveData, "Pembatalan Transaksi Berhasil");

        }catch (Exception e){
            return new DtoResponse(500, null, "Pembatalan Transaksi Gagal");
        }
    }
}
