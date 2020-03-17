package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;
//Kasian-Andriy Nitse 

public class NitseKasian extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if (fundValue<100)
			return Decision.KEEP_FUND;
		else
			return Decision.LIQUIDATE_FUND;
	}

}
