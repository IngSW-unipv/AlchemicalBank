package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;
// Doveri Riccardo 448794
public class DoveriRiccardoWizard extends Wizard {
    private int year;
    private int order;
    private long yourCoins;
    private long partnerCoins;
    private  int time;
    private int yourRevenue;
    private int partnerRevenue;
    private int soglia1 = 11;
    private int soglia2 = 10;
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
        impostaSogliaFine();
    }
    private void alzaSoglia() {
        if (order == 1) {
            if (soglia1 <= 9) {
                soglia1 = soglia1 +2;
            }
        }

        else {
            if (soglia2 <= 10) {
                soglia2 = soglia2 +2;
            }
        }
    }
    private void abbassaSoglia() {
        if (order == 1) {
            if (soglia1 >= 3) {
                soglia1 = soglia1 -2;
            }
        }

        else {
            if (soglia2 >= 4) {
                soglia2 = soglia2 -2;
            }
        }
    }

    private void impostaSoglia(){
        if (yourCoins >= partnerCoins) {
            abbassaSoglia();
        }
        else alzaSoglia();
    }
    private void impostaSogliaFine() {
        if ((yourRevenue-yourCoins)>(partnerRevenue-partnerCoins)) {
        }
        else abbassaSoglia();
    }

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        impostaSoglia();
       if (order == 1) {
           if (timespan >= soglia1) {
               return Decision.LIQUIDATE_FUND;
           }
           else return Decision.KEEP_FUND;
       }
       else {
           if (timespan >= soglia2) {
               return Decision.LIQUIDATE_FUND;
           }
           else return Decision.KEEP_FUND;
       }
    }
}
