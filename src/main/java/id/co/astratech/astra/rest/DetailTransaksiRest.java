package id.co.astratech.astra.rest;

import id.co.astratech.astra.model.DetailTransaksi;
import id.co.astratech.astra.model.User;
import id.co.astratech.astra.response.DtoResponse;
import id.co.astratech.astra.service.DetailTransaksiService;
import id.co.astratech.astra.service.UserService;
import id.co.astratech.astra.vo.DetailTransaksiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detailTransaksi")
@CrossOrigin
public class DetailTransaksiRest {

    @Autowired
    private DetailTransaksiService detailService;

    public DetailTransaksiRest (DetailTransaksiService detailService){
        this.detailService = detailService;
    }
    @PostMapping("/saveDetail")
    public DtoResponse saveDetailTransaksi(@RequestBody List<DetailTransaksiVo> detail){

        for (DetailTransaksiVo item : detail) {
            detailService.saveDetailTransaksi(item);
        }
        return new DtoResponse(200, detail, "Berhasil Menyimpan data");
    }
    @PostMapping("/statusPembayaran")
    public DtoResponse statusPembayaran(@RequestParam("idTransaksi") Integer idTransaksi){
        return detailService.statusPembayaran(idTransaksi);
    }

    @PostMapping("/pembatalanTransaksi")
    public DtoResponse pembatalanTransaksi(@RequestParam("idTransaksi") Integer idTransaksi, @RequestParam("catatan") String catatan){
        return detailService.batalTransaksi(idTransaksi,catatan);
    }
}
