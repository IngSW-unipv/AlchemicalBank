package it.unipv.ingsw.alchemicalbank.wizards;

// Riccardo 449564
import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class GodracciR extends Wizard {
    float XPar2=1, XPar3=3;
    float Found1=9500;
    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {

        if (timespan==XPar2 ||  fundValue<Found1 )
            return Decision.KEEP_FUND;
        else
            return Decision.LIQUIDATE_FUND;

    }

    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        super.newFund(year, order, yourCoins, partnerCoins);
    if (yourCoins>partnerCoins)
        if (year>1050)
        {XPar3=2;}

    }

    @Override
    public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
        super.fundClosed(time, yourRevenue, partnerRevenue);

    }
}
