package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

// Frenkli Buzhiqi

public class FrenkliBuzhiqi extends Wizard{

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		
		if(fundValue > 150 && timespan > 8) {
			return Decision.LIQUIDATE_FUND;
		} else {
			return Decision.KEEP_FUND;
		}
		
	}

}
