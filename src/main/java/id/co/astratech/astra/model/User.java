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
@Table(name = "ms_user")
public class User {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    @Column(name = "email_user")
    private String email;

    @Column(name = "password_user")
    private String password;

    @Column(name = "nama_user")
    private String namaUser;

    @Column(name = "notelp_user")
    private String noTelp;

    @Column(name = "role_user")
    private String role;

    @Column(name = "status_user")
    private String status;
}
