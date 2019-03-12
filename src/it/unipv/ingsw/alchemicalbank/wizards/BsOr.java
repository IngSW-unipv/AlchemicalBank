package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class BsOr extends Wizard {
    private int currentYear;
    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if((timespan>=8 && this.currentYear<10))
            return Decision.LIQUIDATE_FUND;
        return  Decision.KEEP_FUND;

    }

    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        setCurrentYear(year);

    }

    private  void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }
}
