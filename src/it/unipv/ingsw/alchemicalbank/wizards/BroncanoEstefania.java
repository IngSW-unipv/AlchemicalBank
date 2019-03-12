package it.unipv.ingsw.alchemicalbank.wizards;

//Gisela Estefania Broncano Galeas
import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class BroncanoEstefania extends Wizard {
    private int order;
    private long yourCoins;
    private long partnerCoins;
    private int year;
    private int mese;

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if(timespan>=(mese-1))
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

        if(partnerCoins>=(year*8192))
        {
            //si ferma in meia la 10
            mese=10;
        }
        else
        {
            if(partnerCoins>=(year*4096))
            {
                //si ferma in media a 9
                mese=9;
            }
            if(partnerCoins>=(year*2048))
            {
                //in media si ferma a 8
                mese=8;
            }
            if(partnerCoins>=(year*16384))
            {
                mese=11;
            }
            mese=11;
        }


    }
}
