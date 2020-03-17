package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class Paperino extends Wizard {
	
	private int totalGainTillNow = 0;
	private int wichYear = 0;
	 
	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		// TODO Auto-generated method stub
		return Decision.KEEP_FUND;
	}

}
