package Common.Validate;

import java.util.regex.Pattern;

public class Validate {
//    private static final String NAME_REGEX = "^([A-Z][a-z]+\\s*){2,}$";
//    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
//    private static final String IDCARD_REGEX  = "^(\\d{3}\\d{3}\\d{3})$";
//    private static final String GENDER_REGEX = "^(Male|Female|Unknow)$";
//    private static final String RANKCUSTOMER_REGEX = "^(Diamond|Platinum|Gold|Silver|Member)$";

    public static String validateName(String name) {
        String message = null;
        String regex = "^([A-Z][a-z]+\\s*){2,}$";
        if (!name.matches(regex)) {
            message = "Not OK . Customer name invalid";
        }
        return message;
    }

    public static String validateEmail(String email) {
        String message = null;
        String regex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        if (!email.matches(regex)) {
            message = "Not OK. Email invalid";
        }
        return message;
    }

    public static String validateIdCard(String idcard) {
        String message = null;
        String regex = "^(\\d{3}\\d{3}\\d{3})$";
        if (!idcard.matches(regex)) {
            message = "Not OK. Id Card invalid";
        }
        return message;
    }

    public static String validate(String address) {
        String message = null;
        String regex = "^([A-Z][a-z]+\\s*){2,}$";
        if (!address.matches(regex)) {
            message = "Not OK. Address invalid";
        }
        return message;
    }


}
