package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

// Schimperna Irene matr. 458248

public class SchimpernaIrene extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(timespan > 7)
			return Decision.LIQUIDATE_FUND;
		else
			return Decision.KEEP_FUND;
		
	}

}
