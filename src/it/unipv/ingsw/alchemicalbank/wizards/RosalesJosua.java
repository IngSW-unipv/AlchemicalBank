package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

//Rosales Josua 459136
public class RosalesJosua extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
	
		if (fundValue >= 4000 && timespan < 10) {
			return Decision.KEEP_FUND;
		}
		else if (fundValue >= 2000 && timespan < 9) {
			return Decision.KEEP_FUND;
		}
		else if (fundValue >= 1000 && timespan < 8) {
			return Decision.KEEP_FUND;
		}
		else if( fundValue >= 500 && timespan < 7) {
			return Decision.KEEP_FUND;
		}
		else if( fundValue >= 200 && timespan < 6) {
			return Decision.KEEP_FUND;
		}
		else if( fundValue >= 100 && timespan < 5) {
			return Decision.KEEP_FUND;
		}
		else if( fundValue >= 50 && timespan < 4) {
			return Decision.KEEP_FUND;
		}
		else if( fundValue >= 20 && timespan < 3) {
			return Decision.KEEP_FUND;
		}
		else if( fundValue >= 10 && timespan < 2) {
			return Decision.KEEP_FUND;
		}
		
		else
		    return Decision.LIQUIDATE_FUND;
		
	}

}
