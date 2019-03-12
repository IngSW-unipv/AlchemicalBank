package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

/**
 *  Turricelli Erick 449917
 */
public class SmartWizardTurricelli extends Wizard {
    private int year, order;
    private long yourCoins, partnerCoins;


    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if((order == 1 && timespan == 11) || (order == 2 && timespan == 10)) {
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
    }
}
