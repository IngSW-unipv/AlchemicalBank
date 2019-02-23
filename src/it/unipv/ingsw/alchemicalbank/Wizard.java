package it.unipv.ingsw.alchemicalbank;


/**
 * A wizard that is client of the Alchemical Bank.
 */
abstract public class Wizard implements Comparable<Wizard> {

    /// Money made so far.
    private int coins = 0;

    /**
     * This method is called when the wizard has to decide if he wants to close the account or to keep it for another month.
     *
     * @param accountValue current value of the account
     * @param timespan months since when the account was opened
     * @param otherCoins coins owned by the other account holder
     * @return the decision taken by the wizard
     */
    abstract public Decision askKeepOrClose(int accountValue, int timespan, int otherCoins);

    /**
     * Get the name of the Wizard.
     */
    public final String getName() {
        /// Since we plan to have only one wizard for each class, we use the name of the class.
        return this.getClass().getSimpleName();
    }

    /**
     * Add some money to the profit of the wizard.
     */
    final void addCoins(int amount) {
        long new_coins = coins + amount;
        if (new_coins > Integer.MAX_VALUE || new_coins < Integer.MIN_VALUE)
            coins = Integer.MIN_VALUE;
        else
            coins = (int)new_coins;
    }

    /// Return the number of coins owned by the wizard
    public int getCoins() {
        return coins;
    }

    @Override
    public int compareTo(Wizard wizard) {
        return Integer.compare(this.coins, wizard.coins);
    }
}
