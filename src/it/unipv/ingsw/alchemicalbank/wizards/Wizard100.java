package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;


// Claudio Cusano


public class Wizard100 extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if (fundValue < 100)
			return Decision.KEEP_FUND;
		else
			return Decision.LIQUIDATE_FUND;
	}

}