package it.unipv.ingsw.alchemicalbank.wizards;

// Riccardo 449564
import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class GodracciR extends Wizard {

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {

        if (timespan==12 || fundValue>60000) {return Decision.LIQUIDATE_FUND; }
        else
            return Decision.KEEP_FUND;

    }

    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        super.newFund(year, order, yourCoins, partnerCoins);
    }

    @Override
    public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
        super.fundClosed(time, yourRevenue, partnerRevenue);
    }
}
