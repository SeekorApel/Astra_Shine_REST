package id.co.astratech.astra.vo;

import id.co.astratech.astra.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginVo {

    private Integer idUser;

    private String namaUser;

    private String noTelp;

    private String role;

    private String status;

    public LoginVo (User user){
        this.idUser = user.getIdUser();
        this.namaUser = user.getNamaUser();
        this.noTelp = user.getNoTelp();
        this.role = user.getRole();
        this.status = user.getStatus();
    }
}
