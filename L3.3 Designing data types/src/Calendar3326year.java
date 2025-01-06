public class Calendar3326year {
    private Appointment3326[] calendar = new Appointment3326[366];
    private int n;

    public void add(Appointment3326 appointment) {
        if (calendar[appointment.getDate().DAY_OF_YEAR()] != null)
            throw new RuntimeException("Conflict with another appointment.");
        calendar[appointment.getDate().DAY_OF_YEAR()] = appointment;
        n++;
    }

    public int getN() {
        return n;
    }

    public String toString(int i) {
        return String.format("%s", calendar[i]);
    }

    public static void main(String[] args) {
        Calendar3326year calendar = new Calendar3326year();
        Date date1 = new Date(1, 1, 2018);
        Appointment3326 appointment1 = new Appointment3326(date1, "Dentist", "0833999555");
        calendar.add(appointment1);
        Date date2 = new Date(12, 3, 2018);
        Appointment3326 appointment2 = new Appointment3326(date2, "Dentist", "0833999555");
        calendar.add(appointment2);
        for (int i = 1; i < calendar.calendar.length; i++) {
            System.out.printf("Day %3d: %s\n", i, calendar.toString(i));
//            System.out.println(calendar.toString(date.DAY_OF_YEAR()));
        }
//        System.out.println("DAY_OF_YEAR()" + appointment.getDate().DAY_OF_YEAR());
    }
}
