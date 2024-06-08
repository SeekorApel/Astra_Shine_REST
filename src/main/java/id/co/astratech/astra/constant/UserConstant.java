package id.co.astratech.astra.constant;

public class UserConstant {

    public static final String qGetLogin =
            "SELECT * FROM ms_user " +
                    "WHERE email_user = :email AND password_user = :password";

    public static final String qGetEmailUser =
            "SELECT email_user FROM ms_user WHERE email_user = :email";

    public static final String qGetUserByEmail =
            "SELECT * FROM ms_user WHERE email_user = :email";

    public static final String qGetUserByPassword =
            "SELECT * FROM ms_user WHERE password_user = :password";
    
}
