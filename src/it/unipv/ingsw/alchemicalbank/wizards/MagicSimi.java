package it.unipv.ingsw.alchemicalbank.wizards;

//Mago di Ghiazzi Simone Matricola: 446597

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class MagicSimi extends Wizard {
    private int year;
    private int order;
    private long yourCoins;
    private long partnerCoins;
    private int time;
    private int yourRevenue;
    private int partnerRevenue;

    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        this.year = year;
        this.order = order;
        this.yourCoins = yourCoins;
        this.partnerCoins = partnerCoins;
    }

    @Override
    public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
        this.time = time;
        this.yourRevenue = yourRevenue;
        this.partnerRevenue = partnerRevenue;
    }

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if (timespan <= 9)
            return Decision.KEEP_FUND;
        else
            return Decision.LIQUIDATE_FUND;
    }
}
