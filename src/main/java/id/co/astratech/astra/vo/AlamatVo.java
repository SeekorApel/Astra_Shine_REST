package id.co.astratech.astra.vo;

import id.co.astratech.astra.model.Alamat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlamatVo {

    private Integer idAlamat;

    private Integer idUser;

    private String namaAlamat;

    private String alamat;

    private Double langtitude;

    private Double latitude;

    private Integer jarak;

    private String status;

    public AlamatVo(Alamat alamat) {
        this.idAlamat = alamat.getIdAlamat();
        this.idUser = alamat.getIdUser();
        this.namaAlamat = alamat.getNamaAlamat();
        this.alamat = alamat.getAlamat();
        this.langtitude = alamat.getLangtitude();
        this.jarak = alamat.getJarak();
        this.latitude = alamat.getLatitude();
    }
}
