package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;
// Doveri Riccardo 448794
public class DoveriRiccardoWizard extends Wizard {

    private int foundValue;
    private int timespan;

    private int year;
    private int order;
    private long yourCoins;
    private long partnerCoins;

    private int time;
    private int yourRevenue;
    private int partnerRevenue;

    private int punteggio = 0;
    private int soglia = 10;

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        this.foundValue = fundValue;
        this.timespan = timespan;

        if (timespan >= soglia) {
            return Decision.LIQUIDATE_FUND;
        }
        else return Decision.KEEP_FUND;

    }

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

        if ((yourRevenue-yourCoins) > (partnerRevenue-partnerCoins)) {
            punteggio++;
        }
        else {
            punteggio--;
        }
    }
}
