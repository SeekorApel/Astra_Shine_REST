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
@RequestMapping("/transaksi")
public class TransaksiCustRest {
    @Autowired
    private TransaksiCustService transaksiCustService;

    public TransaksiCustRest(TransaksiCustService transaksiCustService){
        this.transaksiCustService = transaksiCustService;
    }
    //status
    @GetMapping("/getAllTransaksiByStatus")
    public DtoResponse getAllTransaksiByStatus(@RequestParam("status") String status){
        return transaksiCustService.getAllTransaksiByStatus(status);
    }

    @GetMapping("/getTransaksiByIdAndStatus")
    public DtoResponse getTransaksiByIdandStatus(@RequestParam("idUser") Integer idUser, @RequestParam("status") String status){
        return transaksiCustService.getTransaksiByIdAndStatus(idUser, status);
    }

    @GetMapping("/getTransaksiById")
    public DtoResponse getTransaksiById(@RequestParam("idUser") Integer idUser){
        return transaksiCustService.getTransaksiById(idUser);
    }

    @GetMapping("/getTransaksiDetail")
    public DtoResponse getTransaksiDetail(@RequestParam("idTransaksi") Integer idTransaksi){
        return transaksiCustService.getTransaksiDetail(idTransaksi);
    }

    @PostMapping("/saveTransaksi")
    public DtoResponse saveTransaksi(@RequestBody TransaksiVo transaksi){
        return transaksiCustService.saveTransaksiCust(transaksi);
    }

    @PostMapping("/batalkanTrsKurir/{idTransaksi}/")
    public DtoResponse batalkanTrsKurir(@PathVariable Integer idTransaksi, @RequestParam("catatan") String catatan) {
        return transaksiCustService.batalkanTrsKurir(idTransaksi, catatan);
    }

    @GetMapping("/getTotalHarga")
    public DtoResponse getTotalHarga(@RequestParam("idTransaksi") Integer idTransaksi){
        return transaksiCustService.getTotalHarga(idTransaksi);
    }
}
