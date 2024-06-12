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
@Table(name = "ms_durasi")
public class Durasi {
    @Id
    @Column(name = "id_durasi")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDurasi;

    @Column(name = "nama_durasi")
    private String namaDurasi;

    @Column(name = "lama_durasi")
    private Integer lamaDurasi;

    @Column(name = "harga_durasi")
    private Integer hargaDurasi;

    @Column(name = "status")
    private String status;
}
