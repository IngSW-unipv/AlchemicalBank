package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class Amadei471573 extends Wizard {
	
	// AMADEI DAVIDE

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		
		if(fundValue >5) {
			return Decision.KEEP_FUND;
		}
		else return Decision.LIQUIDATE_FUND;
	}

}
