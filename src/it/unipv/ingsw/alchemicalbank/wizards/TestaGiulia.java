package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

// Giulia Testa matricola 454943
public class TestaGiulia extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if (timespan < 8) {
			return Decision.KEEP_FUND;
		} else {
			return Decision.LIQUIDATE_FUND;
		}
	}

}
