//package id.co.astratech.astra.service;
//
//import id.co.astratech.astra.model.Transaksi;
//import id.co.astratech.astra.model.User;
//import id.co.astratech.astra.repository.TransaksiCustRepository;
//import id.co.astratech.astra.repository.UserRepository;
//import id.co.astratech.astra.response.DtoResponse;
//import id.co.astratech.astra.vo.TransaksiVo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class TransaksiCustService {
//    @Autowired
//    private TransaksiCustRepository transaksiCustRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public DtoResponse getTransaksiPickUp(Integer idUser){
//        User userDB = userRepository.findById(idUser).orElse(null);
//
//        if(userDB != null){
//            Iterable<Transaksi> transaksiCusts = transaksiCustRepository.getTransaksiPickup(idUser);
//            List<TransaksiVo> transaksiCustVos = new ArrayList<>();
//
//            for (Transaksi item: transaksiCusts){
//                TransaksiVo transaksiCustVo = new TransaksiVo(item);
//                transaksiCustVos.add(transaksiCustVo);
//            }
//            return new DtoResponse(200, transaksiCustVos, "Data Di temukan");
//        }else if(userDB == null) {
//            return new DtoResponse(404, null, "Data User tidak di temukan");
//        }else {
//            return new DtoResponse(500, null, "Terjadi Kesalahan saat mengambil data");
//        }
//    }
//
//    public DtoResponse getTransaksiProses(Integer idUser){
//        User userDB = userRepository.findById(idUser).orElse(null);
//
//        if(userDB != null){
//            Iterable<Transaksi> transaksiCusts = transaksiCustRepository.getTransaksiProses(idUser);
//            List<TransaksiVo> transaksiCustVos = new ArrayList<>();
//
//            for (Transaksi item: transaksiCusts){
//                TransaksiVo transaksiCustVo = new TransaksiVo(item);
//                transaksiCustVos.add(transaksiCustVo);
//            }
//            return new DtoResponse(200, transaksiCustVos, "Data Di temukan");
//        }else if(userDB == null) {
//            return new DtoResponse(404, null, "Data User tidak di temukan");
//        }else {
//            return new DtoResponse(500, null, "Terjadi Kesalahan saat mengambil data");
//        }
//    }
//
//    public DtoResponse getTransaksiSelesai(Integer idUser){
//        User userDB = userRepository.findById(idUser).orElse(null);
//
//        if(userDB != null){
//            Iterable<Transaksi> transaksiCusts = transaksiCustRepository.getTransaksiSelesai(idUser);
//            List<TransaksiVo> transaksiCustVos = new ArrayList<>();
//
//            for (Transaksi item: transaksiCusts){
//                TransaksiVo transaksiCustVo = new TransaksiVo(item);
//                transaksiCustVos.add(transaksiCustVo);
//            }
//            return new DtoResponse(200, transaksiCustVos, "Data Di temukan");
//        }else if(userDB == null) {
//            return new DtoResponse(404, null, "Data User tidak di temukan");
//        }else {
//            return new DtoResponse(500, null, "Terjadi Kesalahan saat mengambil data");
//        }
//    }
//}
