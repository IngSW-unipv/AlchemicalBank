package it.unipv.ingsw.alchemicalbank.wizards;

/*
Alessandro Pasotti 446419
Alessandro Rossi 449396
Giovanni Lotti 447123
Leonardo Montebugnoli 447525
Matteo Poirè 440193

 */

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

import javax.crypto.spec.DESedeKeySpec;
import java.util.Random;

public class RossiAlessandro extends Wizard {

    long diff;
    int order;
    long start;

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {

        if(diff >= 0 || diff<=-24576){
            if(timespan==11){
                return Decision.LIQUIDATE_FUND;
            }
            if(timespan==10){
                return Decision.LIQUIDATE_FUND;
            } else
                return  Decision.KEEP_FUND;
        }



        /*if (diff > -12 && timespan == 1) {
            return Decision.LIQUIDATE_FUND;
        }
        if (diff > -24 && timespan == 2){
            return Decision.LIQUIDATE_FUND;
        }
        if(diff > -48 && timespan == 3){
            return Decision.LIQUIDATE_FUND;
        }
        if(diff > -96 && timespan == 4){
            return Decision.LIQUIDATE_FUND;
        }
        if(diff > -192 && timespan == 5){
            return Decision.LIQUIDATE_FUND;
        }
        if(diff > -384 && timespan == 6){
            return Decision.LIQUIDATE_FUND;
        }
        if(diff > -768 && timespan == 7){
            return Decision.LIQUIDATE_FUND;
        }*/

        if(diff > -1536 && timespan == 8){
            return Decision.LIQUIDATE_FUND;
        }

        if(diff > -3072 && timespan == 9){
            return Decision.LIQUIDATE_FUND;
        }

        if(diff > -6144 && timespan == 10){
            return Decision.LIQUIDATE_FUND;
        }

        if(diff > -12288 && timespan == 11){
            return Decision.LIQUIDATE_FUND;
        }



        return Decision.KEEP_FUND;
    }

    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        this.order=order;
        diff = yourCoins - partnerCoins;
        this.start = yourCoins;

    }

    @Override
    public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
    }

}
