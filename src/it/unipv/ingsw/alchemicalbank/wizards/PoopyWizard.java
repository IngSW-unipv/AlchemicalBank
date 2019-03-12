package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class PoopyWizard extends Wizard {

    /*
     * Sgroi Andrea: 446310
     * Varini Stefania: 437087
     */

    int order;

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if(timespan==7 && order==1) {
            return Decision.LIQUIDATE_FUND;
        } else if (timespan==8 && order==2) {
            return Decision.LIQUIDATE_FUND;
        } else {
            return Decision.KEEP_FUND;
        }
    }

    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        this.order = order;
    }
}
