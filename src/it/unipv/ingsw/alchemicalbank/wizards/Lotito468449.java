package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

// Lotito Davide Pio 468449

public class Lotito468449 extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if (fundValue > 1000) {
			return Decision.LIQUIDATE_FUND;
		} else {
			return Decision.KEEP_FUND;
		}
	}

}
