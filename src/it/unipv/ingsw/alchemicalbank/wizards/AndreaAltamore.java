package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class AndreaAltamore extends Wizard {
	
	//Andrea Altamore 458100
	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		// TODO Auto-generated method stub
		
		if (fundValue < 17000) return Decision.KEEP_FUND;
		else return Decision.LIQUIDATE_FUND;
		
	}

}
