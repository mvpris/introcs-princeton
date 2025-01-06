import java.util.Date;

public class Appointment {
    private Date date;
    private String contact;

    public Appointment(Date date) {
        this.date = new Date(date.getTime());
        this.contact = contact;
    }

    public Date getDate() {
        return new Date(date.getTime());
    }

    public static void main(String[] args) {
        Date date = new Date();
        Appointment appointment = new Appointment(date);

        Date appoinmentDate = appointment.getDate();
        appoinmentDate.setDate(15);

    }
}
