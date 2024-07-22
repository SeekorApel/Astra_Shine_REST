package id.co.astratech.astra.repository;

import id.co.astratech.astra.model.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import static id.co.astratech.astra.constant.TransaksiCustConstant.qGetTrsByIdTrans;

@Repository
public interface OwnerRepository extends JpaRepository<Transaksi, Integer> {
    @Query(value = qGetTrsByIdTrans, nativeQuery = true)
    List<Transaksi> getTrsById(@Param("idTransaksi") Integer idTransaksi);
}
