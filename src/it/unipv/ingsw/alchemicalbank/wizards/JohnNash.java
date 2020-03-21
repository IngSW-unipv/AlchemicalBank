package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

/*
 * Francesco Filpa
 * 460927
 */

public class JohnNash extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		return Decision.LIQUIDATE_FUND;
	}

}
