package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class Minaglia470345 extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(timespan<10)
			return Decision.KEEP_FUND;
		else
			return Decision.LIQUIDATE_FUND;
	}

}
