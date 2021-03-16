package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

// Vecchio Angelo 466550

public class Vecchio466550 extends Wizard {
//prova
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if (timespan == 12) {
			return Decision.LIQUIDATE_FUND;
		} else {
			return null;
		}
	}

}
