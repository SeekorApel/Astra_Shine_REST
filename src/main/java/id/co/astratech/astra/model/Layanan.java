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
@Table(name = "ms_layanan")
public class Layanan {
    @Id
    @Column(name = "id_layanan")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLayanan;

    @Column(name = "nama_layanan")
    private String namaLayanan;

    @Column(name = "harga_layanan")
    private String hargaLayanan;

    @Column(name = "satuan_layanan")
    private String satuanLayanan;

    @Column(name = "status")
    private String status;
}
