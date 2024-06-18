package id.co.astratech.astra.rest;

import id.co.astratech.astra.model.Transaksi;
import id.co.astratech.astra.response.DtoResponse;
import id.co.astratech.astra.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/owner")
public class OwnerRest {

    @Autowired
    private OwnerService ownerService;

    public OwnerRest(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/getAllTrsOwner")
    public DtoResponse getAllTrsOwner(){
        return ownerService.getAllTrsOwner();
    }

    @GetMapping("/getDetailTransaksi")
    public DtoResponse getTransaksiDetail(@RequestParam("idTransaksi") Integer idTransaksi){
        return ownerService.getDetailTransaksi(idTransaksi);
    }

    @PostMapping("/updateTransaksi/{idTransaksi}/")
    public DtoResponse updateStatusPesanan(@PathVariable Integer idTransaksi, @RequestParam("status_pesanan") String status_pesanan) {
        return ownerService.updateTransaksi(idTransaksi, status_pesanan);
    }
}
