public class Appointment3326 {
    private final Date date;
    private final String job;
    private final String contact;

    public Appointment3326(Date date, String job, String contact) {
        this.date = new Date(date.getDay(), date.getMonth(), date.getYear());
        this.job = job;
        this.contact = contact;
    }

    public Date getDate() {
        return new Date(date.getDay(), date.getMonth(), date.getYear());
    }

    public String toString() {
        return String.format("Appointment: %s. Date: %s. Contact number: %s", job, date, contact);
    }

    public static void main(String[] args) {

    }
}
