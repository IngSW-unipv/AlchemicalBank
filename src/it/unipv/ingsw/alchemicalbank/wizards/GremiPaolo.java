package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;



public class GremiPaolo extends Wizard {
    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        return Decision.LIQUIDATE_FUND;
    }

}
