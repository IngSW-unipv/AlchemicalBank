package it.unipv.ingsw.alchemicalbank;


import java.util.logging.Logger;

/**
 * A bank account.
 */
public class Account {

    /// The logger for this class.
    private final static Logger LOGGER = Logger.getLogger(Account.class.getName());
    private static final int MAX_DURATION = 12;
    private static final int CLOSER_PART = 80;
    private int value;
    private int timespan;
    private boolean closed;
    private Wizard[] holders;

    /**
     * Create a new account.
     * @param initialValue starting value of the account
     * @param firstHolder one of the two holders of the account
     * @param secondHolder the other holder
     */
    public Account(int initialValue, Wizard firstHolder, Wizard secondHolder) {
        value = initialValue;
        timespan = 0;
        closed = false;
        holders = new Wizard[2];
        holders[0] = firstHolder;
        holders[1] = secondHolder;
        int cost = -initialValue / 2;
        firstHolder.addCoins(-cost);
        secondHolder.addCoins(-(initialValue - cost));
    }

    /// Advance the account by one month
    public void nextMonth() {
        if (!closed) {
            int active = timespan % 2;
            value *= 2;
            timespan += 1;
            Decision decision = holders[active].askKeepOrClose(value, timespan, holders[1 - active].getCoins());
            closed = (timespan >= MAX_DURATION || decision == Decision.CLOSE_ACCOUNT);
        }
    }

    /// Transfer the account value to its holders
    public void payHolders() {
        int active = (timespan + 1) % 2;
        int part = value * CLOSER_PART / 100;
        holders[active].addCoins(part);
        holders[1 - active].addCoins(value - part);
        int v0 = (active == 0 ? part : value - part);
        int v1 = value - v0;
        String fmt = "%16s closes the account after %2d months: %-16s (%+6d) / %-16s (%+6d)";
        String msg = String.format(fmt,  holders[active].getName(), timespan, holders[0].getName(), v0, holders[1].getName(), v1);
        LOGGER.info(msg);
    }

    /// Tell if the account has been closed or not
    public boolean isClosed() {
        return closed;
    }
}
