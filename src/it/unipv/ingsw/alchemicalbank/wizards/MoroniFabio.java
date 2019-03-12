package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;


/* MORONI FABIO 446148 */

public class MoroniFabio extends Wizard {


    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if (fundValue < 10000 || timespan < 2)
        return Decision.KEEP_FUND;
        else return Decision.LIQUIDATE_FUND;
    }
}
