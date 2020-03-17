package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;


//Matteo Tagliaferri 445953

public class MatteoTagliaferri445953 extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(fundValue<1000) {
			return Decision.KEEP_FUND;
		}
		else return Decision.LIQUIDATE_FUND;
	}

}
