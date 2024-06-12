package id.co.astratech.astra.service;

import id.co.astratech.astra.model.Durasi;
import id.co.astratech.astra.model.Layanan;
import id.co.astratech.astra.repository.DurasiRepository;
import id.co.astratech.astra.response.DtoResponse;
import id.co.astratech.astra.vo.DurasiVo;
import id.co.astratech.astra.vo.LayananVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DurasiService {
    @Autowired
    private DurasiRepository durasiRepository;

    public DtoResponse getAllDurasi(){
        Iterable<Durasi> durasi = durasiRepository.findAll();
        List<DurasiVo> durasiVos = new ArrayList<>();

        for (Durasi item: durasi){
            DurasiVo durasiVo = new DurasiVo(item);
            durasiVos.add(durasiVo);
        }
        return new DtoResponse(200, durasiVos, "Data Di temukan");
    }
    public DtoResponse getDurasiById(Integer idDurasi){
        Iterable<Durasi> durasi = durasiRepository.getDurasiById(idDurasi);
        List<DurasiVo> durasiVos = new ArrayList<>();
        if(durasi != null){
            for (Durasi item: durasi){
                DurasiVo durasiVo = new DurasiVo(item);
                durasiVos.add(durasiVo);
            }
            return new DtoResponse(200, durasiVos, "Sukses");
        }else {
            return new DtoResponse(404, null, "Data Layanan tidak di temukan");
        }

    }
}
