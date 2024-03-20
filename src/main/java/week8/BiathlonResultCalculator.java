package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BiathlonResultCalculator {

    private final Path path;
    private final List<BiathlonAthlete> athletes = new ArrayList<>();

    public BiathlonResultCalculator(Path path) {
        this.path = path;
    }

    public void calculateResults() {
        try (BufferedReader reader = Files.newBufferedReader(path)) {

            String line;
            while ((line = reader.readLine()) != null) {
                parseLine(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        sortAthletes();
    }

    private void parseLine(String line) {
        String[] parts = line.split(",");
        String[] time = parts[3].split(":");

        int athleteNumber = Integer.parseInt(parts[0]);
        String athleteName = parts[1];
        CountryCode countryCode = CountryCode.valueOf(parts[2]);
        int minutes = Integer.parseInt(time[0]);
        int seconds = Integer.parseInt(time[1]);
        String firstShooting = parts[4];
        String secondShooting = parts[5];
        String thirdShooting = parts[6];

        BiathlonAthlete athlete = new BiathlonAthlete(athleteNumber, athleteName, countryCode, minutes, seconds, firstShooting, secondShooting, thirdShooting);
        athletes.add(athlete);
    }

    public void printResults() {
        System.out.println("Winner - " + athletes.get(0));
        System.out.println("Runner-up - " + athletes.get(1));
        System.out.println("Third place - " + athletes.get(2));
    }

    private void sortAthletes() {
        final Comparator<BiathlonAthlete> athleteComparator = Comparator
                .comparing(BiathlonAthlete::getFinalResultMinutes)
                .thenComparing(BiathlonAthlete::getFinalResultSeconds);

        athletes.sort(athleteComparator);
    }
}
