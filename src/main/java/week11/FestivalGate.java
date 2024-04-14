package week11;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FestivalGate {

    private final AtomicInteger attendeeCount = new AtomicInteger();
    private final EnumMap<TicketType, List<FestivalAttendeeThread>> attendees = new EnumMap<>(TicketType.class);

    public synchronized void addAttendee(final FestivalAttendeeThread attendeeThread) {
        attendees.computeIfAbsent(attendeeThread.getTicketType(), v -> new ArrayList<>());
        attendees.get(attendeeThread.getTicketType()).add(attendeeThread);

        attendeeCount.incrementAndGet();
    }

    public int getAttendeeCount() {
        return attendeeCount.intValue();
    }

    public Map<TicketType, List<FestivalAttendeeThread>> getAttendees() {
        return this.attendees;
    }
}
