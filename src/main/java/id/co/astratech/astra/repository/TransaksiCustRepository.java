package id.co.astratech.astra.repository;

import id.co.astratech.astra.model.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static id.co.astratech.astra.constant.TransaksiCustConstant.*;

public interface TransaksiCustRepository extends JpaRepository<Transaksi, Integer> {
    @Query(value = qGetTransaksiPickup, nativeQuery = true)
    List<Transaksi> getTransaksiPickup(@Param("idUser") Integer idUser);

    @Query(value = qGetAllTransaksiByStatus, nativeQuery = true)
    List<Transaksi> getAllTransaksiByStatus(@Param("status") String status);

    @Query(value = qGetTransaksiProses, nativeQuery = true)
    List<Transaksi> getTransaksiProses(@Param("idUser") Integer idUser);

    @Query(value = qGetTransaksiSelesai, nativeQuery = true)
    List<Transaksi> getTransaksiSelesai(@Param("idUser") Integer idUser);

    @Query(value = qGetTransaksiDetail, nativeQuery = true)
    List<Transaksi> getTransaksiDetail(@Param("idTransaksi") Integer idTransaksi);

}
