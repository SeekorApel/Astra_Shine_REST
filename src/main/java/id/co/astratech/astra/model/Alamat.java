package id.co.astratech.astra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ms_alamat")
public class Alamat {

    @Id
    @Column(name = "id_alamat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlamat;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "nama_alamat")
    private String namaAlamat;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "langtitude_alamat")
    private Double langtitude;

    @Column(name = "latitude_alamat")
    private Double latitude;

    @Column(name = "jarak")
    private Integer jarak;

    @Column(name = "status")
    private String status;

}
