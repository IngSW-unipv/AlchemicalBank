package it.unipv.ingsw.alchemicalbank.wizards;

//ACCORNERO STEFANO 471318

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class Accornero471318 extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if (fundValue < 5000)
			return Decision.KEEP_FUND;
		else 
			return Decision.LIQUIDATE_FUND;
	}

}
