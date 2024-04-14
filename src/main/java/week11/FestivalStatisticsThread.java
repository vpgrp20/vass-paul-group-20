package week11;

public class FestivalStatisticsThread implements Runnable {
    private final FestivalGate gate;

    public FestivalStatisticsThread(final FestivalGate gate) {
        this.gate = gate;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            printStatistics();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void printStatistics() {
        System.out.println(gate.getAttendeeCount() + " people entered");
        System.out.println();
        gate.getAttendees().forEach((key, value) -> System.out.println(key.getTicketName() + " -> " + value.size() + " attendees"));
    }
}
