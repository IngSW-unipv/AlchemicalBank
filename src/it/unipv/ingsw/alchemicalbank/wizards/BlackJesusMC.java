package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

import java.util.Random;

public class BlackJesusMC extends Wizard {

    Random r = new Random();
    double monthToStopLow;
    double monthToStopHigh;

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {

        if (timespan % 2 == 0) { //Wizard 2
            if ((((double)timespan / 12)) >= 0 || (((double)timespan / 12)) <= 6) {

                if ( ((double)timespan / 12) != (this.monthToStopLow = lowGaussian())) {
                    return Decision.KEEP_FUND;
                } else
                    {

                    return Decision.LIQUIDATE_FUND;

                    }
            } else {
                if ((((double)timespan / 12)) > 6 || (((double)timespan / 12)) <= 12) {

                    if (((double)timespan / 12) == (this.monthToStopHigh = highGaussian())) {

                        return Decision.LIQUIDATE_FUND;

                    } else {

                        return Decision.KEEP_FUND;
                    }

                }
            }
        }else{//Wizard 1
                if(timespan % 9 == 0){
                    return Decision.LIQUIDATE_FUND;

                }else{

                    return Decision.KEEP_FUND;
                }
            }

            return null;
        }

        private double lowGaussian () {

            double mySample = (r.nextGaussian() * 2.44) + 3;

            return mySample;

        }

        private double highGaussian () {

            double mySample = (r.nextGaussian() * 2) + 9;

            return mySample;

        }


}