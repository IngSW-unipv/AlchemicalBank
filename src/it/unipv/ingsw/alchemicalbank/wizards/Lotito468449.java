package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

// autore: Lotito Davide Pio
// matricola: 468449

public class Lotito468449 extends Wizard {
	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		
		if ( timespan%2 ==1 && fundValue>2000 ) {
			return Decision.LIQUIDATE_FUND;
		} else if ( timespan>=10 ){
			return Decision.LIQUIDATE_FUND;
		} else {
			return Decision.KEEP_FUND;
		}
	}

}
