package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class GentiliniRoberto extends Wizard {

    private int mese;
    private boolean vinto;

    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        mese = 11;
        long partnerYearly = partnerCoins / year;
        if (partnerYearly > 10000) {mese = 10;}
    }

    public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
        if (yourRevenue >= partnerRevenue) {vinto = true;}
        else {vinto = false;}
    }

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if (timespan >= mese) {return Decision.LIQUIDATE_FUND;}
        else {return Decision.KEEP_FUND;}
    }

}
