package id.co.astratech.astra.service;

import id.co.astratech.astra.model.Alamat;
import id.co.astratech.astra.model.Layanan;
import id.co.astratech.astra.model.User;
import id.co.astratech.astra.repository.LayananRepository;
import id.co.astratech.astra.repository.UserRepository;
import id.co.astratech.astra.response.DtoResponse;
import id.co.astratech.astra.vo.AlamatVo;
import id.co.astratech.astra.vo.LayananVo;
import id.co.astratech.astra.vo.LoginVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LayananService {
    @Autowired
    private LayananRepository layananRepository;

    public DtoResponse getAllLayanan(){
        Iterable<Layanan> layanan = layananRepository.findAll();
        List<LayananVo> layananVos = new ArrayList<>();

        for (Layanan item: layanan){
            LayananVo layananVo = new LayananVo(item);
            layananVos.add(layananVo);
        }
        return new DtoResponse(200, layananVos, "Data Di temukan");
    }
    public DtoResponse getLayananById(Integer idLayanan){
        Iterable<Layanan> layanan = layananRepository.getLayananById(idLayanan);
        List<LayananVo> layananVos = new ArrayList<>();
        if(layanan != null){
            for (Layanan item: layanan){
                LayananVo layananVo = new LayananVo(item);
                layananVos.add(layananVo);
            }
            return new DtoResponse(200, layananVos, "Sukses");
        }else {
            return new DtoResponse(404, null, "Data Layanan tidak di temukan");
        }

    }
}
