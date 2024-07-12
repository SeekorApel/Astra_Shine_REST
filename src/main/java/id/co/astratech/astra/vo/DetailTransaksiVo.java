package id.co.astratech.astra.vo;

import id.co.astratech.astra.model.DetailTransaksi;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetailTransaksiVo {
    private Integer idTransaksi;
    private Integer idLayanan;
    private String namaLayanan;
    private Double qty;

    public DetailTransaksiVo(DetailTransaksi detailTransaksi) {
        this.idTransaksi = detailTransaksi.getDetailTransaksiPK().getId_transaksi();
        this.idLayanan = detailTransaksi.getDetailTransaksiPK().getId_layanan();
        this.namaLayanan = detailTransaksi.getNama_layanan();
        this.qty = detailTransaksi.getQty();
    }
}
