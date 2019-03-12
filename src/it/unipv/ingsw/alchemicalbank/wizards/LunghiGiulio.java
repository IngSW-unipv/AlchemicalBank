package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class LunghiGiulio extends Wizard {
    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if(timespan == 8 || timespan == 9) {
            return Decision.LIQUIDATE_FUND;
        }
        else {
            return Decision.KEEP_FUND;
        }
    }
}
