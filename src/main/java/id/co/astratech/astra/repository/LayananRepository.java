package id.co.astratech.astra.repository;

import id.co.astratech.astra.model.Alamat;
import id.co.astratech.astra.model.Layanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static id.co.astratech.astra.constant.AlamatConstant.qGetAlamatByIdUser;
import static id.co.astratech.astra.constant.LayananConstant.qGetLayananById;
import static id.co.astratech.astra.constant.UserConstant.qGetLogin;

public interface LayananRepository extends JpaRepository<Layanan, Integer> {
    @Query(value = qGetLayananById, nativeQuery = true)
    List<Layanan> getLayananById(@Param("idLayanan") Integer idLayanan);
}
