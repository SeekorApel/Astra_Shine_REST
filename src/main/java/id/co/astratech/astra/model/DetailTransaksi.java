package id.co.astratech.astra.model;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "tr_transaksi_detail")
public class DetailTransaksi  implements Serializable {

    @EmbeddedId
    private DetailTransaksiPK detailTransaksiPK;

    @Column(name = "qty")
    private Integer qty;
}
