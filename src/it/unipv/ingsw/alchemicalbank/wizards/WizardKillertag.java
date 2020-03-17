package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class WizardKillertag extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(fundValue<90000) {
			return Decision.KEEP_FUND;
			//aggiungo un commento 
		}else {
			return Decision.LIQUIDATE_FUND;
		}
	}

}
