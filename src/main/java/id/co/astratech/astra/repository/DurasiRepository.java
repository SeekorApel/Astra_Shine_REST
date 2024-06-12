package id.co.astratech.astra.repository;

import id.co.astratech.astra.model.Durasi;
import id.co.astratech.astra.model.Layanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static id.co.astratech.astra.constant.DurasiConstant.qGetDurasiById;

public interface DurasiRepository extends JpaRepository<Durasi, Integer> {
    @Query(value = qGetDurasiById, nativeQuery = true)
    List<Durasi> getDurasiById(@Param("idDurasi") Integer idDurasi);
}
