package week11;

import java.util.concurrent.ThreadLocalRandom;

public enum TicketType {

    FULL("full"),
    FULL_VIP("full VIP"),
    FREE_PASS("free pass"),
    ONE_DAY("one day pass"),
    ONE_DAY_VIP("one day VIP");

    private final String type;

    TicketType(String type) {
        this.type = type;
    }

    public String getTicketName() {
        return type;
    }

    public static TicketType getAtRandom() {
        int size = TicketType.values().length;
        return TicketType.values()[ThreadLocalRandom.current().nextInt(size)];
    }
}
