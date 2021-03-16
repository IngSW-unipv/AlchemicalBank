package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;

public class Bobba466486 {
	//prova wizard
	
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		
		if(timespan==7||timespan==8) {
			return Decision.LIQUIDATE_FUND;
		}
		else
			return Decision.KEEP_FUND;
		
	}
	
}
