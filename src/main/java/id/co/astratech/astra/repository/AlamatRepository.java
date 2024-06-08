package id.co.astratech.astra.repository;

import id.co.astratech.astra.model.Alamat;
import id.co.astratech.astra.vo.AlamatVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import static id.co.astratech.astra.constant.AlamatConstant.*;

@Repository
public interface AlamatRepository extends JpaRepository<Alamat, Integer> {

    @Query(value = qGetAlamatByIdUser, nativeQuery = true)
    List<Alamat> getAlamatByIdUser(@Param("idUser") Integer idUser,@Param("status") String status);

}
