package id.co.astratech.astra.vo;

import id.co.astratech.astra.model.Layanan;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LayananVo {
    private Integer idLayanan;

    private String namaLayanan;

    private String hargaLayanan;

    private String satuanLayanan;

    private String status;

    public LayananVo(Layanan layanan) {
        this.idLayanan = layanan.getIdLayanan();
        this.namaLayanan = layanan.getNamaLayanan();
        this.hargaLayanan = layanan.getHargaLayanan();
        this.satuanLayanan = layanan.getSatuanLayanan();
        this.status = layanan.getStatus();
    }
}
