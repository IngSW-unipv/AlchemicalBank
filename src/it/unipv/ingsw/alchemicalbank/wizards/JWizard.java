package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class JWizard extends Wizard{

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		while(fundValue < 100000 &&  timespan <= 20) {
			return Decision.KEEP_FUND;
		}
		return Decision.LIQUIDATE_FUND;
		
		
	}

}
