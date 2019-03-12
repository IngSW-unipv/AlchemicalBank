package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Wizard;
import it.unipv.ingsw.alchemicalbank.Decision;

//Andrea Stella 447213
//Roberto Zappa 450488

public class STELLAZAPPA extends Wizard {

    Decision scelta;
    int year, order;
    long yourCoins,partnerCoins;

    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
            long partnerCoinsMedia = partnerCoins / year;
            long ottantaPercento = (80 * fundValue) / 100;

            if (ottantaPercento * 2 >= partnerCoinsMedia) {
                return Decision.LIQUIDATE_FUND;
            } else {
                return Decision.KEEP_FUND;
            }
    }

    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        this.year=year;
        this.order=order;
        this.yourCoins=yourCoins;
        this.partnerCoins=partnerCoins;
    }


}
