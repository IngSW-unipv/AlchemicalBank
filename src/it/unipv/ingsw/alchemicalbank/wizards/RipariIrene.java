package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class RipariIrene extends Wizard {

	//Irene Ripari 457927
	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if (timespan == 6 && fundValue < 250) {
			return Decision.KEEP_FUND;
		}
		if (timespan > 6 && fundValue > 20000) {
			return Decision.LIQUIDATE_FUND;
		}
		if (timespan < 6 && fundValue < 100) {
			return Decision.KEEP_FUND;
		} else {
			return Decision.KEEP_FUND;
		}

	}

}
