package bai10_stack_queue.baitap.ManagementAgency;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.SimpleTimeZone;

public class ComparatorByBirthday implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = simpleDateFormat.parse(o1.getBirthday());
            date2 = simpleDateFormat.parse(o2.getBirthday());
            return date1.compareTo(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
