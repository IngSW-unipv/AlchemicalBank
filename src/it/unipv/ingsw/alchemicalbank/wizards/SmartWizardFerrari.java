package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Wizard;
import it.unipv.ingsw.alchemicalbank.Decision;

/*Enrico Ferrari
matricola 444439
 */

public class SmartWizardFerrari extends Wizard {
    private int year, order, risk = 1;
    private long yourCoins, partnerCoins;


    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if((order == 1 && timespan == 11) || (order == 2 && timespan == 10)) {
            return  Decision.LIQUIDATE_FUND;
        }
        return Decision.KEEP_FUND;
    }

    public void newFund(int year, int order, long yourCoins, long partnerCoins){
        this.year= year;
        this.order= order;
        this.yourCoins=yourCoins;
        this.partnerCoins= partnerCoins;
    }
}
