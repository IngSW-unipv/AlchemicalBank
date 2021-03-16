package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class Gamba467951 extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		// TODO Auto-generated method stub
		if (timespan>7) {
			return Decision.LIQUIDATE_FUND;
		}
		else {
			return Decision.KEEP_FUND;
		}
	}

}
