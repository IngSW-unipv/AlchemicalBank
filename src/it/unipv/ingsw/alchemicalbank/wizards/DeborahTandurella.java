package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;



// Deborah Tandurella 455299


import it.unipv.ingsw.alchemicalbank.Wizard;

public class DeborahTandurella extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(fundValue < 1000) {
			return Decision.KEEP_FUND;
		} else {
			return Decision.LIQUIDATE_FUND;
		}
	}

}
