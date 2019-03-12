package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;


public class Rocchetti2Wizard extends Wizard {



    /**
     * @author Francesco Rocchetti 445854
     *
     * @return
     */

    int target = 12;
    int order;

    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        this.order = order;
        if(year>10){
            target = (int)((partnerCoins/year)*1.20);
        }
    }

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {

        if (timespan >= 10) {
            return Decision.LIQUIDATE_FUND;
        }

 /*       //peggiora il risultato
        if (fundValue >= target) {
            return Decision.LIQUIDATE_FUND;
        }
*/
        return Decision.KEEP_FUND;
    }
}
