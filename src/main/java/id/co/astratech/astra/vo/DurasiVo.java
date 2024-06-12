package id.co.astratech.astra.vo;

import id.co.astratech.astra.model.Durasi;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DurasiVo {
    private Integer idDurasi;

    private String namaDurasi;

    private Integer lamaDurasi;

    private Integer hargaDurasi;

    private String status;

    public DurasiVo(Durasi durasi) {
        this.idDurasi = durasi.getIdDurasi();
        this.namaDurasi = durasi.getNamaDurasi();
        this.lamaDurasi = durasi.getLamaDurasi();
        this.hargaDurasi = durasi.getHargaDurasi();
        this.status = durasi.getStatus();
    }
}
