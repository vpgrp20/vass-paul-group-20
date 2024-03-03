package week4;

public class HomeworkWeek4 {
    public static void main(String[] args) {
        Phone phone = new GalaxyS23("ASDFGH12345", Color.BLUE);
        phone.addContact("1", "12345", "firstName1", "lastName1");
        phone.addContact("2", "98765", "firstName2", "lastName2");

        phone.getFirstContact();
        phone.getSecondContact();

        phone.sendMessage("12345", "some random message");
        phone.call("12345");
        phone.call("12345");

        System.out.println();
        phone.viewHistory();

        phone.call("98765");
        phone.call("98765");
        phone.call("98765");

        System.out.println();
        phone.viewHistory();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Phone phone1 = new Iphone12("abcdefgh098765", Color.BLACK);
        phone1.addContact("1", "1234", "contactFirstName", "contactLastName");
        phone1.sendMessage("1234", "sending first message");
        phone1.sendMessage("1234", "sending second message");

        System.out.println();
        phone1.getFirstMessage("1234");
        phone1.getSecondMessage("1234");
    }
}
