package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class Cignoli469989 extends Wizard {

	
	
/*	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(timespan >= 11){
			return Decision.LIQUIDATE_FUND;
		} else {
			return Decision.KEEP_FUND;
		}
	
	}
*/
	
	@Override
 	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
 		if (fundValue <= 18000 || timespan <9) {
 			return Decision.KEEP_FUND;
 		}
 		else return Decision.LIQUIDATE_FUND;
 	}
}
