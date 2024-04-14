package week11;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statistics = new FestivalStatisticsThread(gate);
        Thread t = new Thread(statistics);
        t.start();

        final int numberOfAttendees = ThreadLocalRandom.current().nextInt(100, 500);
        for (int i = 0; i < numberOfAttendees; i++) {
            new Thread(new FestivalAttendeeThread(gate)).start();
        }
    }
}
