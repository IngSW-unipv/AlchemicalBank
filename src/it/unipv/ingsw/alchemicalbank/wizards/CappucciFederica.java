package it.unipv.ingsw.alchemicalbank.wizards;
//Cappucci Lucia Federica 446400

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class CappucciFederica extends Wizard {
    private int order;
    private long yourCoins;
    private long partnerCoins;
    private int year;
    private int mese=11;

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if(timespan>=(mese))
        {
            return Decision.LIQUIDATE_FUND;
        }
        return Decision.KEEP_FUND;
    }
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        this.order=order;
        this.yourCoins=yourCoins+this.yourCoins;
        this.partnerCoins=partnerCoins;
        this.year=year;
        if(partnerCoins>=(year-1*8192))
        {
            //si ferma in media la 10
            mese=10;
        }
        else
        {
            if(partnerCoins>=(year-1*2048))
            {
                //in media si ferma a 8
                mese=8;
            }
            if(partnerCoins>=(year-1*4096))
            {
                //si ferma in media a 9
                mese=9;
            }
            if(partnerCoins>=(year-1*16384))
            {
                mese=11;
            }
          //  mese=11;

        }



    }
    public void  fundClosed(int time, int yourRevenue, int partnerRevenue) {
        this.yourCoins=yourCoins+yourRevenue;
    }
}
