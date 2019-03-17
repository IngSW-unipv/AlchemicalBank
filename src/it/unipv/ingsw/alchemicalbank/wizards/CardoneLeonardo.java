package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class CardoneLeonardo extends Wizard {

    /**
     * Cardone Leonardo matr 348295**/

    private int foundValue;
    private int timespan;
    private int year;
    private long partnerCoins;
    private long yourCoins;
    private int mese=11;
    private int order;

    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        this.order = order;
        this.yourCoins = yourCoins + this.yourCoins;
        this.partnerCoins = partnerCoins;
        this.year = year;
        magia(this.partnerCoins,this.year);
    }

    private int magia(long pc, int y) {
        if (pc >= (y - 1 * 8192)) {
            mese = 10;
        } else {
            if (pc >= (y - 1 * 2048)) {
                //in media si ferma a 8
                mese = 8;
            }
            if (pc >= (y - 1 * 4096)) {
                //si ferma in media a 9
                mese = 9;
            }
            if (pc >= (y - 1 * 16384)) {
                mese = 11;
            }
            //  mese=11;

        }
        return mese;
    }

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        this.foundValue = fundValue;
        this.timespan = timespan;

        if (year > 45) {
            if (partnerCoins > yourCoins) {
                mese = 9;
            }
            else {
                mese = 10;
            }
        }
        if (timespan >= mese) {
            return Decision.LIQUIDATE_FUND;
        }
        else return Decision.KEEP_FUND;


    }
}
