package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class PezziStefano extends Wizard {

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if (fundValue < 8192)
            return Decision.KEEP_FUND;
        else
            return Decision.LIQUIDATE_FUND;
    }
}
