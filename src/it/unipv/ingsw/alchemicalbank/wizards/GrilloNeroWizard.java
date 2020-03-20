package it.unipv.ingsw.alchemicalbank.wizards;

//Grillone Edoardo
//Pusineri Andrea

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;
//import java.util.Random;

public class GrilloNeroWizard extends Wizard {

    private int timeToLiquidate;
    private int year;
    private int order;
    private long myCoins;
    private long partnerCoins;
//    private Random random = new Random();

    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        super.newFund(year, order, yourCoins, partnerCoins);
        this.year = year;
        this.order = order;
        this.myCoins = yourCoins;
        this.partnerCoins = partnerCoins;
        autoSetTimeToLiquidate(myCoins, partnerCoins);
    }

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if (timespan >= timeToLiquidate) {
            return Decision.LIQUIDATE_FUND;
        } else {
            return Decision.KEEP_FUND;
        }
    }

    @Override
    public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
        super.fundClosed(time, yourRevenue, partnerRevenue);
//        System.out.println("[DEBUG] mine|their: " + myCoins + "|" + partnerCoins);
    }

    private void autoSetTimeToLiquidate(long myCoins, long partnerCoins) {
        timeToLiquidate = 11;
//        if (order == 2 && random.nextBoolean()) {
//            timeToLiquidate -= 1;
//        }
        if (myCoins > (partnerCoins * 2)) {
            timeToLiquidate -= 1;
        } else if (myCoins > (partnerCoins * 3)) {
            timeToLiquidate -= 3;
        }
    }

}
