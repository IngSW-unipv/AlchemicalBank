package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class Toscanini466649 extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if((fundValue > 1000)&&(timespan > 6)){
			
			return Decision.LIQUIDATE_FUND;
			
		}else {
			return Decision.KEEP_FUND;
		}
	}

}
