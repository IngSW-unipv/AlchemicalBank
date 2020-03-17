package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

//Davide Spalenza 454097
public class DavideSpalenza extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(fundValue<18000) return Decision.KEEP_FUND;
		else return Decision.LIQUIDATE_FUND;
	}

}
