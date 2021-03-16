package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class Ibba470702 extends Wizard{
	
	//Nicola Ibba 470702
	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if (fundValue > 1000 && Math.random() > 0.70) {
			return Decision.LIQUIDATE_FUND;
		} else {
			return Decision.KEEP_FUND;
		}
		
	}

}
