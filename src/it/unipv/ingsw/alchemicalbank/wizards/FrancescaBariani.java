package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class FrancescaBariani extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if (fundValue <= 18000 || timespan < 9) {
			return Decision.KEEP_FUND;
		}
		else return Decision.LIQUIDATE_FUND;
	}

}
