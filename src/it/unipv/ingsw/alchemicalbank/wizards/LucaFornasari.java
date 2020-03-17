package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class LucaFornasari extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if (fundValue == 1024 || fundValue == 2048) {
			return Decision.LIQUIDATE_FUND;
		}
		else 
			return Decision.KEEP_FUND;
	}

}