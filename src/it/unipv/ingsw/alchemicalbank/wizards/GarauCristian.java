package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class GarauCristian extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(fundValue > 20000) {
			return Decision.LIQUIDATE_FUND;
		}else {
			return Decision.KEEP_FUND;
		}
	}

}
