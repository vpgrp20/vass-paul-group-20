package week7;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
//        BiathlonAthlete athlete = new BiathlonAthlete(11, "Umar Jorgson", CountryCode.CZ, 30, 27, "xxxox", "xxxxx", "xxoxo");
//        System.out.println(athlete);
        Path biathlonResults = Path.of("src/main/resources/AthleteResults.txt");
        BiathlonResultCalculator biathlon = new BiathlonResultCalculator(biathlonResults);
        biathlon.calculateResults();
        biathlon.printResults();
    }
}
