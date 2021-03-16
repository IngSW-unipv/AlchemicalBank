package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

import java.util.Random;

/**
 * A wizard that decides randomly.
 */
public class WackyWizard extends Wizard {

    private Random randomGenerator = new Random();

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if (randomGenerator.nextBoolean())
            return Decision.KEEP_FUND;
        else
            return Decision.LIQUIDATE_FUND;
    }
}
