package id.co.astratech.astra.model;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tr_transaksi_detail")
public class DetailTransaksi  implements Serializable {

    @EmbeddedId
    private DetailTransaksiPK detailTransaksiPK;

    @Column(name = "qty")
    private Double qty;

}
