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
        if((order == 1 && timespan == 11)) {
            return  Decision.LIQUIDATE_FUND;
        }

        if(timespan == risk*2 && fundValue > 0.40*yourCoins) {
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

        if(yourCoins < (partnerCoins - 0.25*partnerCoins)) {
            risk++;
            if(risk > 3) {
                risk = 3;
            }
        }
        else if(yourCoins > (partnerCoins + 0.5*partnerCoins)) {
            risk--;
            if(risk < 1) {
                risk = 1;
            }
        }
    }
}
