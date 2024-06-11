package id.co.astratech.astra.rest;

import id.co.astratech.astra.response.DtoResponse;
import id.co.astratech.astra.service.AlamatService;
import id.co.astratech.astra.service.LayananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/layanan")
public class LayananRest {
    @Autowired
    private LayananService layananService;

    public LayananRest(LayananService layananService){
        this.layananService = layananService;
    }

    @GetMapping("/getAllLayanan")
    public DtoResponse getAllLayanan(){
        return layananService.getAllLayanan();
    }
    @GetMapping("/getLayananById")
    public DtoResponse getLayananById(@RequestParam("idLayanan") Integer idLayanan){
        return layananService.getLayananById(idLayanan);
    }
}
