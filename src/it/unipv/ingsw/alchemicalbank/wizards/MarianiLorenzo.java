package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class MarianiLorenzo extends Wizard {

    //MARAZZI FEDERICO 448929
    //MARIANI LORENZO 448295

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if (timespan >= 10) {
            return Decision.LIQUIDATE_FUND;
        }
        else{
            return Decision.KEEP_FUND;
        }
    }
}
