package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class MatteoZaccariniWizard extends Wizard{
    /**
     * A wizard by Matteo Zaccarini matricola 463195
     */
    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if (timespan < 10)
            return Decision.KEEP_FUND;
        else
            return Decision.LIQUIDATE_FUND;
    }
}