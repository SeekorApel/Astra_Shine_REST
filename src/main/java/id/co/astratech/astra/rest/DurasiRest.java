package id.co.astratech.astra.rest;

import id.co.astratech.astra.response.DtoResponse;
import id.co.astratech.astra.service.DurasiService;
import id.co.astratech.astra.service.LayananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/durasi")
public class DurasiRest {
    @Autowired
    private DurasiService durasiService;

    public DurasiRest(DurasiService durasiService){
        this.durasiService = durasiService;
    }

    @GetMapping("/getAllDurasi")
    public DtoResponse getAllDurasi(){
        return durasiService.getAllDurasi();
    }
    @GetMapping("/getDurasiById")
    public DtoResponse getDurasiById(@RequestParam("idDurasi") Integer idDurasi){
        return durasiService.getDurasiById(idDurasi);
    }
}
