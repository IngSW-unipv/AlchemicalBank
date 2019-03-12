/**
 *
 * Mago di Fabio Riganti, Edoardo Cotellessa e Matteo Lucchini
 *
 */
package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class Wizaaaaaard extends Wizard {
    private long partnerCoins;
    private int year;
    private int order;

    public Wizaaaaaard() {
        partnerCoins = 0;
        year = 0;
    }

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if (year == 1){
            if (timespan == 11) return Decision.LIQUIDATE_FUND;
            else return Decision.KEEP_FUND;
        }

        int fondoBasso = (year-1)*128;
        int fondoMedio = (year-1)*2048;

        if (partnerCoins <= fondoBasso){
            if(timespan == 3 || timespan == 4) return Decision.LIQUIDATE_FUND;
            else return Decision.KEEP_FUND;
        }

        if (partnerCoins <= fondoMedio){
            if(timespan == 7 || timespan == 8) return Decision.LIQUIDATE_FUND;
            else return Decision.KEEP_FUND;
        }

        if(timespan == 11 || timespan == 12) return Decision.LIQUIDATE_FUND;
        else return Decision.KEEP_FUND;
    }

    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        super.newFund(year, order, yourCoins, partnerCoins);
        this.partnerCoins = partnerCoins;
        this.year = year;
    }
}
