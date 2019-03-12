package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

/**
 *  Lodigiani Giacomo 447138
 */
public class SmartWizardLodigiani extends Wizard {
    private int year, order, risk = 7;
    private long yourCoins, partnerCoins;


    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if((order == 1 && timespan == 11) || (order == 2 && timespan == 10)) {
            return  Decision.LIQUIDATE_FUND;
        }

        if(timespan == risk && fundValue > 0.25*yourCoins) {
            return  Decision.LIQUIDATE_FUND;
        }

        return Decision.KEEP_FUND;
    }

    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        this.year = year;
        this.order = order;
        this.yourCoins = yourCoins;
        this.partnerCoins = partnerCoins;

        if(yourCoins < (partnerCoins - 0.05*partnerCoins)) {
            risk = 9;
        }
        else if(yourCoins > (partnerCoins + 0.10*partnerCoins)) {
            risk = 10;
        }
    }
}