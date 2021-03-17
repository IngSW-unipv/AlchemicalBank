package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

/**
 * A wizard that wants his money right now.
 */
public class GreedyWizard extends Wizard {
    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        return Decision.LIQUIDATE_FUND;
    }
}
