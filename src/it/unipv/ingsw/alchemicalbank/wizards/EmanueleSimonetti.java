package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

//Emanuele Simonetti 457750

public class EmanueleSimonetti extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		
		if (fundValue <= 500)
			return Decision.KEEP_FUND;
		else 
			return Decision.LIQUIDATE_FUND; 
		
		
	}

}
