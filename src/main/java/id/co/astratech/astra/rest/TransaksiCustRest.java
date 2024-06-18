package id.co.astratech.astra.rest;

import id.co.astratech.astra.response.DtoResponse;
import id.co.astratech.astra.service.AlamatService;
import id.co.astratech.astra.service.TransaksiCustService;
import id.co.astratech.astra.vo.TransaksiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/transaksis")
public class TransaksiCustRest {
    @Autowired
    private TransaksiCustService transaksiCustService;

    public TransaksiCustRest(TransaksiCustService transaksiCustService){
        this.transaksiCustService = transaksiCustService;
    }

    @GetMapping("/getTransaksiCustPickUp")
    public DtoResponse getTransaksiCustPickUp(@RequestParam("idUser") Integer idUser){
        return transaksiCustService.getTransaksiPickUp(idUser);
    }

    @GetMapping("/getTransaksiCustProses")
    public DtoResponse getTransaksiCustProses(@RequestParam("idUser") Integer idUser){
        return transaksiCustService.getTransaksiProses(idUser);
    }

    @GetMapping("/getTransaksiCustSelesai")
    public DtoResponse getTransaksiCustSelesai(@RequestParam("idUser") Integer idUser){
        return transaksiCustService.getTransaksiSelesai(idUser);
    }

    @GetMapping("/getTransaksiDetail")
    public DtoResponse getTransaksiDetail(@RequestParam("idTransaksi") Integer idTransaksi){
        return transaksiCustService.getTransaksiDetail(idTransaksi);
    }

    @PostMapping("/saveTransaksi")
    public DtoResponse saveTransaksi(@RequestBody List<TransaksiVo> transaksiList){
        DtoResponse response = new DtoResponse();

        // Iterasi melalui setiap TransaksiVo dalam daftar
        for (TransaksiVo transaksi : transaksiList) {
            DtoResponse individualResponse = transaksiCustService.saveTransaksiCust(transaksi);
        }

        return response;
    }
}
