package it.unipv.ingsw.alchemicalbank;


/**
 * A wizard that is client of the Alchemical Bank.
 */
abstract public class Wizard {

    /**
     * Get the name of the Wizard.
     */
    public final String getName() {
        /// Since we plan to have only one wizard for each class, we use the name of the class.
        return this.getClass().getSimpleName();
    }

    /**
     * This method is called when the wizard has to decide if he wants to close the fund or to keep it for another month.
     *
     * @param fundValue current value of the fund
     * @param timespan  months since when the fund was opened
     * @return the decision taken by the wizard
     */
    abstract public Decision askKeepOrLiquidate(int fundValue, int timespan);


    /**
     * Called when a new fund get opened.  By default does nothing, but subclasses may override it if they want to use
     * this information to adjust their strategy.
     *
     * @param year         Year of simulation (starting from 1)
     * @param order        whether is is the first (1) or second (2) to take decisions
     * @param partnerCoins amount of coins owned by the wizard before the new fund is opened
     * @param partnerCoins amount of coins owned by the partner
     */
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        /* Do nothing */
    }

    /**
     * Called when a fund gets liquidated.  By default does nothing, but subclasses may override it if they want to use
     * this information to adjust their strategy.
     *
     * @param time months since the fund was opened
     * @param yourRevenue the revenue due to the wizard
     * @param partnerRevenue the revenue due to the partner
     */
    public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
        /* Do nothing */
    }
}
