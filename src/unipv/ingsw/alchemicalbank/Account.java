package unipv.ingsw.alchemicalbank;


/**
 * A bank account.
 */
public class Account {

    private static final int MAX_DURATION = 12;
    private static final int CLOSER_PART = 80;
    private int value;
    private int timespan;
    private boolean closed;
    private Wizard[] holders;

    public Account(int initalValue, Wizard firstHolder, Wizard secondHolder) {
        value = initalValue;
        timespan = 0;
        closed = false;
        holders = new Wizard[2];
        holders[0] = firstHolder;
        holders[1] = secondHolder;
    }

    public void advance() {
        if (!closed) {
            int active = timespan % 2;
            Decision decision = holders[active].askKeepOrClose(value, timespan, holders[1 - active].getCoins());
            if (decision == Decision.KEEP_ACCOUNT) {
                value *= 2;
                timespan += 1;
                closed = (timespan == MAX_DURATION);
            } else {
                closed = true;
            }
        }
    }

    public void payHolders() {
        int active = timespan % 2;
        int part = value * CLOSER_PART / 100;
        holders[active].addCoins(part);
        holders[1 - active].addCoins(value - part);
    }

    /// Tell if the account has been closed or not.
    public boolean isClosed() {
        return closed;
    }
}
