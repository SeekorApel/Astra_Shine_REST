package id.co.astratech.astra.constant;

public class UserConstant {

    public static final String qGetLogin =
            "SELECT id_user, nama_user, notelp_user, role_user, status_user " +
                    "FROM ms_user " +
                    "WHERE email_user = ? AND password_user = ?";


}
