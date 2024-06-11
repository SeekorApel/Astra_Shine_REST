//package id.co.astratech.astra.rest;
//
//import id.co.astratech.astra.response.DtoResponse;
//import id.co.astratech.astra.service.AlamatService;
//import id.co.astratech.astra.service.TransaksiCustService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@CrossOrigin
//@RequestMapping("/transaksiCust")
//public class TransaksiCustRest {
//    @Autowired
//    private TransaksiCustService transaksiCustService;
//
//    public TransaksiCustRest(TransaksiCustService transaksiCustService){
//        this.transaksiCustService = transaksiCustService;
//    }
//
//    @GetMapping("/getTransaksiCustPickUp")
//    public DtoResponse getTransaksiCustPickUp(@RequestParam("idUser") Integer idUser){
//        return transaksiCustService.getTransaksiPickUp(idUser);
//    }
//
//    @GetMapping("/getTransaksiCustProses")
//    public DtoResponse getTransaksiCustProses(@RequestParam("idUser") Integer idUser){
//        return transaksiCustService.getTransaksiProses(idUser);
//    }
//
//    @GetMapping("/getTransaksiCustSelesai")
//    public DtoResponse getTransaksiCustSelesai(@RequestParam("idUser") Integer idUser){
//        return transaksiCustService.getTransaksiSelesai(idUser);
//    }
//}
