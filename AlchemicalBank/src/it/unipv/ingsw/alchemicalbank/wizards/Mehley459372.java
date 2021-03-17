package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

// Denys Mehley 459372

public class Mehley459372 extends Wizard {

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if (fundValue > 80) {
            return Decision.LIQUIDATE_FUND;
        } else {
            return Decision.KEEP_FUND;
        }
    }

}
