package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;
public class CrescentiRiccardo extends Wizard {

    //crescenti riccardo 447250

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {


        if (timespan > 9 && timespan < 12) {
            return Decision.LIQUIDATE_FUND;
        } else {
            return Decision.KEEP_FUND;
        }

    }
}
