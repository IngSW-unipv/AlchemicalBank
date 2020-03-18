package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

// Rotaru Daniel 458867

public class RotaruDaniel extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if (timespan < 8)
			return Decision.KEEP_FUND;
		else
			return Decision.LIQUIDATE_FUND;
	}

}
