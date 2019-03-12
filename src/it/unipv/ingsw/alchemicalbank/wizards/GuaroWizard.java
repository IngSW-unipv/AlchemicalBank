package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class GuaroWizard extends Wizard {
    private long partnerCoins;
    private long myCoins;
    private int myRevenue;
    private int partnerRevenue;
    private int year;
    public Decision askKeepOrLiquidate(int fundValue, int timespan){

            if (timespan>2)
                return Decision.LIQUIDATE_FUND;
            else
                return Decision.KEEP_FUND;

    }

    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        super.newFund(year, order, yourCoins, partnerCoins);
        myCoins= yourCoins;
        this.partnerCoins= partnerCoins;
        this.year=year;

    }

    @Override
    public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
        super.fundClosed(time, yourRevenue, partnerRevenue);
        this.partnerRevenue=partnerRevenue;
        myRevenue=yourRevenue;
    }
}
