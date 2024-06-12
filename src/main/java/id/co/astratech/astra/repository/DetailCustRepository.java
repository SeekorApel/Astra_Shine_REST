package id.co.astratech.astra.repository;

import id.co.astratech.astra.model.DetailTransaksi;
import id.co.astratech.astra.model.DetailTransaksiPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static id.co.astratech.astra.constant.TransaksiCustConstant.qGetTransaksiDetail;

public interface DetailCustRepository extends JpaRepository<DetailTransaksi, DetailTransaksiPK> {
@Query(value = qGetTransaksiDetail, nativeQuery = true)
    List<DetailTransaksi> getDetailTransaksi(@Param("idTransaksi") Integer idTransaksi);


}
