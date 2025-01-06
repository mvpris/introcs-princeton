import java.util.Calendar;

public class test {
    public static void main(String[] args) {
        Date date = new Date(1, 1, 1995);
//        boolean valid = date.isValid(1, 1, 1995);

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
    }
}
