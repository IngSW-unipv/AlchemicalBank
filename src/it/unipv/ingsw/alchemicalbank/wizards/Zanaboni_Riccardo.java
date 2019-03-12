package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;


// ZANABONI RICCARDO 445667

public class Zanaboni_Riccardo extends Wizard {
    private int i = 11;

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if (timespan == i || timespan == i + 1) {
            return Decision.LIQUIDATE_FUND;
        } else {
            return Decision.KEEP_FUND;
        }
    }
}

