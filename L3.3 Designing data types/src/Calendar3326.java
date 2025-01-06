public class Calendar3326 {
    private Appointment3326[] calendar = new Appointment3326[1];
    private int n;

    public void resize() {
        Appointment3326[] temp = new Appointment3326[n * 2];
        System.arraycopy(calendar, 0, temp, 0, calendar.length);
        calendar = temp;
    }

    public void add(Appointment3326 appointment) {
        for (Appointment3326 appointment3326 : calendar) {
            if (appointment3326.getDate() == appointment.getDate())
                throw new RuntimeException("Day is already booked with another appointment.");
        }
        if (n == calendar.length) resize();
        calendar[n++] = appointment;
    }

    public String toString(int i) {
        return String.format("%s\n", calendar[i]);
    }

    public static void main(String[] args) {

    }
}
