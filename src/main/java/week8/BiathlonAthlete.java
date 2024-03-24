package week8;

public class BiathlonAthlete {

    private final int athleteNumber;
    private final String athleteName;
    private final CountryCode countryCode;
    private final int resultMinutes;
    private final int resultSeconds;
    private final String firstShooting;
    private final String secondShooting;
    private final String thirdShooting;

    private int finalResultMinutes;
    private int finalResultSeconds;
    private int addedSeconds;

    public BiathlonAthlete(int athleteNumber, String athleteName, CountryCode countryCode, int resultMinutes, int resultSeconds, String firstShooting, String secondShooting, String thirdShooting) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.resultMinutes = resultMinutes;
        this.resultSeconds = resultSeconds;
        this.firstShooting = firstShooting;
        this.secondShooting = secondShooting;
        this.thirdShooting = thirdShooting;

        finalResultMinutes = resultMinutes;
        finalResultSeconds = resultSeconds;

        calculateFinalTime();
    }

    public String getAthleteName() {
        return athleteName;
    }

    public int getFinalResultMinutes() {
        return finalResultMinutes;
    }

    public int getFinalResultSeconds() {
        return finalResultSeconds;
    }

    private int calculateAddedSeconds() {
        final String s = new StringBuilder(firstShooting)
                .append(secondShooting)
                .append(thirdShooting)
                .toString();

        int misses = 0;
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equalsIgnoreCase("o")) {
                misses++;
            }
        }
        return misses * 10;
    }

    private void calculateFinalTime() {
        addedSeconds = calculateAddedSeconds();

        int totalSeconds = addedSeconds + resultSeconds;
        int totalAddedMinutes = totalSeconds / 60;
        int finalSeconds = totalSeconds % 60;

        finalResultMinutes += totalAddedMinutes;
        finalResultSeconds = finalSeconds;
    }

    @Override
    public String toString() {
        return athleteName + " " + finalResultMinutes + ":" + finalResultSeconds + " (" + resultMinutes + ":" + resultSeconds + " + " + addedSeconds + ")";
    }
}
