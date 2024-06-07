package id.co.astratech.astra.constant;

public class UserConstant {

    public static final String qGetLogin =
            "SELECT * FROM ms_user " +
                    "WHERE email_user = :email AND password_user = :password";
    
}
