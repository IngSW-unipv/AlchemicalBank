package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

/**
 * A wizard that wants his money right now.
 */
public class Scardovi470583Wizard extends Wizard {
    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
    	
		if (timespan == 7 || timespan == 10) {
			return Decision.LIQUIDATE_FUND;
		} 

		return Decision.KEEP_FUND;
    }
}
