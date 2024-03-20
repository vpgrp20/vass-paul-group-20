package week8;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Path biathlonResults = Path.of("src/main/resources/AthleteResults.txt");
        BiathlonResultCalculator biathlon = new BiathlonResultCalculator(biathlonResults);
        biathlon.calculateResults();
        biathlon.printResults();
    }
}
