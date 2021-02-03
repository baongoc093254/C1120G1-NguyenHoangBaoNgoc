package CaseStudy.Commons.Validation;


import java.util.regex.Pattern;

public class CustomerValidation {
    private static final String NAME_REGEX = "^([A-Z][a-z]+\\s*){2,}$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String IDCARD_REGEX  = "^(\\d{3}\\d{3}\\d{3})$";
    public static boolean validateName(String name){
        return Pattern.matches(NAME_REGEX,name);
    }
    public static boolean validateEmail(String email)  {
        return Pattern.matches(EMAIL_REGEX,email);

    }
    public static boolean validateIdCard(int idcard) {
        return Pattern.matches(IDCARD_REGEX,Integer.toString(idcard));

    }
}
