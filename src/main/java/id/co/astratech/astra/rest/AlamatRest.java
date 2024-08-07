package id.co.astratech.astra.rest;

import id.co.astratech.astra.model.Alamat;
import id.co.astratech.astra.response.DtoResponse;
import id.co.astratech.astra.service.AlamatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/alamat")
public class AlamatRest {

    @Autowired
    private AlamatService alamatService;

    public AlamatRest(AlamatService alamatService){
        this.alamatService = alamatService;
    }

    @GetMapping("/getAlamatLaundry")
    public DtoResponse getAlamatLaundry(){
        return alamatService.getAlamatLaundry();
    }

    @GetMapping("/getAlamatUser")
    public DtoResponse getAllAlamatUserByStatus(@RequestParam("idUser") Integer idUser){
        return alamatService.getAllAlamatByStatusAndIdUser(idUser);
    }

    @PostMapping("/updateAlamatUser")
    public DtoResponse updateAlamat(@RequestBody Alamat updateAlamat){
        return alamatService.updateAlamat(updateAlamat);
    }

    @PostMapping("/saveAlamatUser")
    public DtoResponse saveAlamat(@RequestBody Alamat alamat){
        return alamatService.saveAlamat(alamat);
    }

    @PostMapping("/deleteAlamat")
    public DtoResponse deleteAlamat(@RequestParam("idAlamat") Integer idAlamat){
        return alamatService.deleteAlamat(idAlamat);
    }

}
