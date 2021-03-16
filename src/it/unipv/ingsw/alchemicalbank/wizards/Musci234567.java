package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

// Mirto Musci 123456

public class Musci234567 extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if (timespan > 10) {
			return Decision.LIQUIDATE_FUND;
		} else {
			return Decision.KEEP_FUND;
		}
	}

}
