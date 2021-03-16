package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

// CREMONESI ALESSANDRO WIZARD 472563

public class Cremonesi472563 extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		
		if(timespan > 10 ) {
			return Decision.LIQUIDATE_FUND;
		} else return Decision.KEEP_FUND;
	}

}
