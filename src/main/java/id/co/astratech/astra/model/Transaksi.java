package id.co.astratech.astra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tr_transaksi")
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaksi")
    private Integer id_transaksi;

    @Column(name = "id_user")
    private Integer id_user;

    @Column(name = "id_durasi")
    private Integer id_durasi;

    @Column(name = "tanggal_pesanan")
    private Date tanggal_pesanan;

    @Column(name = "tanggal_pengiriman")
    private Date tanggal_pengiriman;

    @Column(name = "status_pembayaran")
    private String status_pembayaran;

    @Column(name = "status_pesanan")
    private String status_pesanan;

    @Column(name = "ongkir")
    private Integer ongkir;

    @Column(name = "total_harga")
    private Integer total_harga;
}
