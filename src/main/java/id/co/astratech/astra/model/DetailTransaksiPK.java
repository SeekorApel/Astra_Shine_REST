package id.co.astratech.astra.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class DetailTransaksiPK implements Serializable {
    @Column(name = "id_transaksi")
    private Integer id_transaksi;

    @Column(name = "id_layanan")
    private Integer id_layanan;

    public DetailTransaksiPK() {
    }

    public DetailTransaksiPK(Integer id_transaksi, Integer id_layanan) {
        this.id_transaksi = id_transaksi;
        this.id_layanan = id_layanan;
    }
}
