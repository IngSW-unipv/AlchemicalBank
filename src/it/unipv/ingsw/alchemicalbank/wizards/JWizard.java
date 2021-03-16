package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class JWizard extends Wizard{

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(timespan > 12) {
			return Decision.LIQUIDATE_FUND;
		}
		return Decision.KEEP_FUND;
		
	}

}
