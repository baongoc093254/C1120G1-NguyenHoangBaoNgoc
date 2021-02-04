package CaseStudy.Commons.Validation;


import java.util.regex.Pattern;

public class CustomerValidation {
    private static final String NAME_REGEX = "^([A-Z][a-z]+\\s*){2,}$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String IDCARD_REGEX  = "^(\\d{3}\\d{3}\\d{3})$";
    private static final String GENDER_REX = "^(Male|Female|Unknow)$";
    private static final String RANKCUSTOMER_REGEX = "^(Diamond|Platinum|Gold|Silver|Member)$";
    public static boolean validateName(String name){
        return Pattern.matches(NAME_REGEX,name);
    }
    public static boolean validateEmail(String email)  {
        return Pattern.matches(EMAIL_REGEX,email);

    }
    public static boolean validateIdCard(int idcard) {
        return Pattern.matches(IDCARD_REGEX,Integer.toString(idcard));

    }
    public static boolean validateGender(String gender) {
        return Pattern.matches(GENDER_REX,gender);
    }
    public static boolean validateRankCustomer(String rankCustomer) {
        return Pattern.matches(RANKCUSTOMER_REGEX,rankCustomer);
    }

}
