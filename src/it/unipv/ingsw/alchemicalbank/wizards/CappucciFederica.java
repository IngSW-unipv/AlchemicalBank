package it.unipv.ingsw.alchemicalbank.wizards;
//Cappucci Lucia Federica 446400

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class CappucciFederica extends Wizard {
    private int order=0;
    private long yourCoins=100000;

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if(timespan==7)
        {
            return Decision.LIQUIDATE_FUND;
        }
        return Decision.KEEP_FUND;
    }
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        this.order=order;
        this.yourCoins=yourCoins+this.yourCoins;
    }

}
