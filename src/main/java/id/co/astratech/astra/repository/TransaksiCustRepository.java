package id.co.astratech.astra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static id.co.astratech.astra.constant.TransaksiCustConstant.*;

public interface TransaksiCustRepository extends JpaRepository<TransaksiCust, Integer> {
    @Query(value = qGetTransaksiPickup, nativeQuery = true)
    List<TransaksiCust> getTransaksiPickup(@Param("idUser") Integer idUser);

    @Query(value = qGetTransaksiProses, nativeQuery = true)
    List<TransaksiCust> getTransaksiProses(@Param("idUser") Integer idUser);

    @Query(value = qGetTransaksiSelesai, nativeQuery = true)
    List<TransaksiCust> getTransaksiSelesai(@Param("idUser") Integer idUser);

    @Query(value = qGetTransaksiDetail, nativeQuery = true)
    List<TransaksiCust> getTransaksiDetail(@Param("idTransaksi") Integer idTransaksi);

}
