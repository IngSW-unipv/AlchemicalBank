/*
    Mattia Bosio
    Matteo Orsolini
 */

package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class BsOr extends Wizard {
    private int currentYear;
    private int my_order;

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if (my_order == 2)
            return Decision.KEEP_FUND;
        else if (my_order == 1 && timespan == 11)
            return Decision.LIQUIDATE_FUND;
        return Decision.KEEP_FUND;

    }

    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        setCurrentYear(year);
        this.my_order = order;

    }

    private void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }
}
