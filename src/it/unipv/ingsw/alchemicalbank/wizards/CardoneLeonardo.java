package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class CardoneLeonardo extends Wizard{

    private long yourCoins;
    private  long order;
    private long partnerCoins;
    private int year;
    private int mese=11;


    /**
     * Cardone Leonardo 348295**/

    public void  fundClosed(int time, int yourRevenue, int partnerRevenue) {

        this.yourCoins=yourCoins+yourRevenue;
    }


    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if (timespan > 9 && timespan < 12) {
            return Decision.LIQUIDATE_FUND;
        } else {
            return Decision.KEEP_FUND;
        }
    }

    @Override
    public void newFund(int year ,int order, long yourCoins, long partnerCoins) {
        this.order=order;
        this.yourCoins=yourCoins;
        this.partnerCoins=partnerCoins;
        this.year=year;
        play(this.partnerCoins,this.year);
    }

    private void play(long pc, int y) {
        if (partnerCoins >= (year - 1 * 8192)) {
            mese = 12;
        } else {
            if (partnerCoins >= (year - 1 * 2048)) {
                //in media si ferma a 8
                mese = 8;
            }
            if (partnerCoins >= (year - 1 * 4096)) {
                //si ferma in media a 9
                mese = 9;
            }
            if (partnerCoins >= (year - 1 * 16384)) {
                mese = 11;
            }


        }
    }
}
