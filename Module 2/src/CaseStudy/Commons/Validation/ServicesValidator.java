package CaseStudy.Commons.Validation;

import java.util.regex.Pattern;

public class ServicesValidator {

    public static final String ID_VILLA ="^SVVL-\\d{4}$";
    public static boolean validateIdVilla(String id) {
        return Pattern.matches(ID_VILLA,id);
    }

    public static final String ID_HOUSE = "^SVHO-\\d{4}$";
    public static boolean validateIdHouse(String id) {
        return Pattern.matches(ID_HOUSE,id);
    }

    public static final String ID_ROOM = "^SVRO-\\d{4}$";
    public static boolean validateIdRoom(String id) {
        return Pattern.matches(ID_ROOM,id);
    }


//       Name Service - Regex

    public static final String NAMESERVICE_REGEX = "^[A-Z]([a-z]{1,})$";
    public static boolean validateNameService(String nameServices) {
        return Pattern.matches(NAMESERVICE_REGEX,nameServices);
    }


//      Area using - regex
    public static final String AREA_USING = "^([3-9]\\d|[1-9]\\d{2,})\\.\\d+$";
    public static boolean validateAreaUsing(float areaUsing) {
        return Pattern.matches(AREA_USING,Float.toString(areaUsing));
    }

//      Price - regex
    public static final String PRICE = "^\\d{1,8}\\.(\\d{1,4})$";
    public static boolean validatePrice(double price) {
        return Pattern.matches(PRICE,Double.toString(price));
    }

//    Number People
    public static final String NUMBER_PEOPLE = "^([0-1][0-9])$";
    public static boolean validateNumPeople(int numPeople) {
        return Pattern.matches(NUMBER_PEOPLE,Integer.toString(numPeople));
    }

//    Floor
    public static final String NUMBER_FLOOR = "^\\d$";
    public static boolean validateFloor(int numFloor) {
        return Pattern.matches(NUMBER_FLOOR,Integer.toString(numFloor));
    }

//    Type Room
    public static final String TYPE_ROOM = "^([A-Z][a-z]+)$";
    public static boolean validateTypeRoom(String typeRoom) {
        return Pattern.matches(TYPE_ROOM,typeRoom);
    }
//    Area Pool
    public static final String AREA_POOL = "^([3-9]\\d|[1-9]\\d{2,})\\.\\d+$";
    public static boolean validateAreaPool(float areaPool) {
        return Pattern.matches(AREA_POOL,Float.toString(areaPool));
    }

}
