package week11;

public class FestivalAttendeeThread implements Runnable {

    private final TicketType type;
    private final FestivalGate gate;

    public FestivalAttendeeThread(final FestivalGate gate) {
        this.type = TicketType.getAtRandom();
        this.gate = gate;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            gate.addAttendee(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public TicketType getTicketType() {
        return type;
    }

}
