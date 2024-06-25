package id.co.astratech.astra.repository;

import id.co.astratech.astra.model.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Transaksi, Integer> {

}
