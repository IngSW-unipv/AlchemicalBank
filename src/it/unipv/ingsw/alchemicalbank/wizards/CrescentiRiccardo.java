package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;
//crescenti riccardo 447250
public class CrescentiRiccardo extends Wizard {

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        return Decision.KEEP_FUND;
    }


}
