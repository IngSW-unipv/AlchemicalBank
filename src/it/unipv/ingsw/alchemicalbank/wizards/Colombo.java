package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class Colombo extends Wizard {

    private int foundValue;
    private int timespan;


    private int soglia = 11;

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        this.foundValue = fundValue;
        this.timespan = timespan;

        if (year > 45) {
            if (partnerCoins>yourCoins) {
                soglia = 9;
            }
            else {
                soglia = 10;
            }
        }
        if (timespan >= soglia) {
            return Decision.LIQUIDATE_FUND;
        }
        else return Decision.KEEP_FUND;

    }


    }
}