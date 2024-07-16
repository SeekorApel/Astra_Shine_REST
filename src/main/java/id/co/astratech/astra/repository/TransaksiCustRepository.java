package id.co.astratech.astra.repository;

import id.co.astratech.astra.model.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static id.co.astratech.astra.constant.TransaksiCustConstant.*;
import static id.co.astratech.astra.constant.TransaksiCustConstant.qGetTransaksiById;

public interface TransaksiCustRepository extends JpaRepository<Transaksi, Integer> {
    @Query(value = qGetAllTransaksiByStatus, nativeQuery = true)
    List<Transaksi> getAllTransaksiByStatus(@Param("status") String status);

    @Query(value = qGetTransaksiByIdAndStatus, nativeQuery = true)
    List<Transaksi> getTransaksiByIdAndStatus(@Param("idUser") Integer idUser, @Param("status") String status);

    @Query(value = qGetTransaksiById, nativeQuery = true)
    List<Transaksi> getTransaksiById(@Param("idUser") Integer idUser);

    @Query(value = qGetTransaksiDetail, nativeQuery = true)
    List<Transaksi> getTransaksiDetail(@Param("idTransaksi") Integer idTransaksi);

    @Query(value = getTotalHarga, nativeQuery = true)
    List<Transaksi> getTotalHarga(@Param("idTransaksi") Integer idTransaksi);


}
