package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

//Andrea Giuliani

public class Wizard102 extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(timespan == 5 && fundValue > 300)
			return Decision.LIQUIDATE_FUND;
		else
			return Decision.KEEP_FUND;
	}

}
