package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;

//Ioicaliuc Ioan MIhail 458968


import it.unipv.ingsw.alchemicalbank.Wizard;

public class IoicaliucMichele extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if (fundValue < 100) 
			return Decision.KEEP_FUND;
		else
			return Decision.LIQUIDATE_FUND;
			
		
	
	}

}
