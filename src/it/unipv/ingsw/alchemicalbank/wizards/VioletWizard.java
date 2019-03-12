package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

import java.util.Random;

 /*
   Schinelli 440468
   Fioravanti 439822
   Singh 437667
   Viola 436102
 */

public class VioletWizard extends Wizard {
    long coinsNemico, myCoins;
    int currentYear;
    int myRevenue, enemyRevenue;
    @Override
     public Decision askKeepOrLiquidate(int fundValue, int timespan) {




            if(currentYear < 7) {
                if (coinsNemico > myCoins) {
                    return Decision.LIQUIDATE_FUND;
                } else {
                    return Decision.KEEP_FUND;
                }
            }
            else {
                if(myRevenue > 1000) {
                    return Decision.LIQUIDATE_FUND;
                }
                else {
                    return  Decision.KEEP_FUND;
                }
            }
        }

    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        super.newFund(year, order, yourCoins, partnerCoins);
        coinsNemico = partnerCoins;
        myCoins = yourCoins;
        currentYear = year;
    }

    @Override
    public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
        super.fundClosed(time, yourRevenue, partnerRevenue);
        myRevenue = yourRevenue;
        enemyRevenue = partnerRevenue;
    }
}
