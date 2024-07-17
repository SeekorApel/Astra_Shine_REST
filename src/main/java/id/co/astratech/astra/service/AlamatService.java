package id.co.astratech.astra.service;

import id.co.astratech.astra.model.Alamat;
import id.co.astratech.astra.model.User;
import id.co.astratech.astra.repository.AlamatRepository;
import id.co.astratech.astra.repository.UserRepository;
import id.co.astratech.astra.response.DtoResponse;
import id.co.astratech.astra.vo.AlamatVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlamatService {

    @Autowired
    private AlamatRepository alamatRepository;

    @Autowired
    private UserRepository userRepository;

    public DtoResponse getAlamatLaundry(){
        Integer idAlamat = 1;
        Alamat alamatDb = alamatRepository.findById(idAlamat).orElse(null);
        if(alamatDb != null){
            return new DtoResponse(200, alamatDb, "Data Di temukan");
        }else {
            return new DtoResponse(500, null, "Data tidak di temukan");
        }
    }

    public DtoResponse saveAlamat(Alamat alamat){
        try {
            User existingUser = userRepository.findById(alamat.getIdUser()).orElse(null);

            if(existingUser != null){
                Alamat data = new Alamat();
                BeanUtils.copyProperties(alamat, data);
                data.setStatus("Aktif");
                alamatRepository.save(data);
                return new DtoResponse(200, alamat, "Sukses Membuat Data");
            }else {
                return new DtoResponse(404, null, "Alamat Tidak di temukan");
            }

        }catch (Exception e){
            return new DtoResponse(500, null,"Terjadi saat menambahkan data " + e.getMessage());
        }
    }

    public DtoResponse updateAlamat(Alamat updateAlamat){
        try {
            Alamat alamatDb = alamatRepository.findById(updateAlamat.getIdAlamat()).orElse(null);
            if(alamatDb != null){
                alamatRepository.save(updateAlamat);
                return new DtoResponse(200, updateAlamat, "Sukses mengupdate data");
            }else {
                return new DtoResponse(404, null, "Tidak dapat mengupdate Data");
            }
        }catch (Exception e){
            return new DtoResponse(500, null,"Terjadi saat merubah data " + e.getMessage());
        }
    }

    public DtoResponse getAllAlamatByStatusAndIdUser(Integer idUser){
        String status = "Aktif";
        Iterable<Alamat> alamats = alamatRepository.getAlamatByIdUser(idUser, status);
        List<AlamatVo> alamatVos = new ArrayList<>();
        if(alamats != null){
            for (Alamat item: alamats){
                AlamatVo alamatVo = new AlamatVo(item);
                alamatVo.setStatus(alamatVo.getStatus() == null ? "" : alamatVo.getStatus());
                alamatVos.add(alamatVo);
            }
            return new DtoResponse(200, alamatVos, "Data Di temukan");

        }else if(alamats == null){
            return new DtoResponse(404, null, "Data tidak di temukan");
        }else {
            return new DtoResponse(500, null, "Terjadi Kesalahan saat mengambil data");
        }
    }

    public DtoResponse deleteAlamat(Integer idAlamat){
        try {
            Alamat alamatDB = alamatRepository.findById(idAlamat).orElse(null);
            Alamat deleteAlamat = new Alamat();
            BeanUtils.copyProperties(alamatDB, deleteAlamat);
            deleteAlamat.setStatus("Tidak Aktif");
            alamatRepository.save(deleteAlamat);
            return new DtoResponse(200, deleteAlamat, "Suskses Menghapus Data Alamat");
        }catch (Exception e){
            return new DtoResponse(500, null, "Terjadi Kesalahan dalam menghapus data " + e.getMessage());
        }
    }

}
