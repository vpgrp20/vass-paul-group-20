package week10;

public class Main {
    public static void main(String[] args) {
        FileProcessingApplication app = new FileProcessingApplication();
        app.processFiles("src/main/resources/ResourceFileWeek10", 3, "src/main/java/week10/OutputFile.txt");
    }
}
