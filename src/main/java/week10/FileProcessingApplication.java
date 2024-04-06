package week10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
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
                            writer.write(user.getFirstName() + "," + user.getLastName() + "\n");
                        } catch (IOException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    });

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<String> getUserNames(String targetFile) {
        Path filePath = Path.of(targetFile);
        List<String> result = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                result.add(parts[1]);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
