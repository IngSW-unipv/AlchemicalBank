package it.unipv.ingsw.alchemicalbank.wizards;


import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class CespiPolisiani468935 extends Wizard {
	
	
	public int getRandomTimespan(int minTimespan, int maxTimespan) {
		return (int)((Math.random() * (maxTimespan - minTimespan)) + minTimespan);
	}
	
	public Decision  askKeepOrLiquidate(int fundValue, int timespan) {
		int randomTimespan = getRandomTimespan(7,12);
		
		if (timespan == randomTimespan) {
			return Decision.LIQUIDATE_FUND;
		} else {
			return Decision.KEEP_FUND;
		}
	}
}
