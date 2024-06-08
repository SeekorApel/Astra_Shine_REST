package id.co.astratech.astra.constant;

public class AlamatConstant {

    public static final String qGetAlamatByIdUser =
            "SELECT * FROM ms_alamat WHERE id_user = :idUser AND status = :status ORDER BY id_alamat DESC";

}
