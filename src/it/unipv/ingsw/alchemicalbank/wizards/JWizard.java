package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class JWizard extends Wizard{

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		fundValue += 100000000;
		return Decision.LIQUIDATE_FUND;
		
		
	}

}
