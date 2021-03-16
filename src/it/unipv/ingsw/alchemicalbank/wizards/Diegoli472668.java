package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class Diegoli472668 extends Wizard {

	//Diegoli
	
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
			if (timespan == 11) return Decision.LIQUIDATE_FUND;
			else return Decision.KEEP_FUND;	
	}

}
