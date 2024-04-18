package week12;

public class Main {
    public static void main(String[] args) {
        BookingApplication app = new BookingApplication();
        app.selectFromAccomodationTable();
        System.out.println(app.getPricePerRoom());
    }
}
