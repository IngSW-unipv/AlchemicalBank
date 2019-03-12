package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

import java.util.Random;

/*

* Armandola Federico 447587
* Belcore Daniel 447520

 */

public class ArmandolaFederico extends Wizard {

    private Random randomGenerator = new Random();
    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {

        if (randomGenerator.nextBoolean())
            return Decision.KEEP_FUND;
        else
            return Decision.LIQUIDATE_FUND;
    }
}
