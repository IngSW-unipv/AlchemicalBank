package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

//Giulia Coraglia 456665

public class CoragliaGiulia extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if (fundValue <= 600)
			return Decision.KEEP_FUND;
		else
			return Decision.LIQUIDATE_FUND;
		
		
	}

}
