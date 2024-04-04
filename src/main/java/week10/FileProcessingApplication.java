package week10;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class FileProcessingApplication {

    public void processFiles(String inputFile, int targetMonth, String outputFile) {
        Path input = Path.of(inputFile);
        Path output = Path.of(outputFile);

        try (Stream<String> lines = Files.lines(input);
             BufferedWriter writer = Files.newBufferedWriter(output)) {

            final List<User> users = lines.map(line -> line.split(","))
                    .map(line -> new User(line[0], line[1], line[2].split("\\.")))
                    .toList();

            users.stream()
                    .filter(user -> user.getDoB().getMonth().getValue() == targetMonth)
                    .sorted(Comparator.comparing(User::getLastName).thenComparing(User::getFirstName))
                    .forEach(user -> {
                        try {
                            writer.write(user.getFirstName() + ", " + user.getLastName() + "\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
