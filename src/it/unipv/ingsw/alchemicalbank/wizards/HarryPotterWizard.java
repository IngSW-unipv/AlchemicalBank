package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

// Christian Kareem Cianci 436085

public class HarryPotterWizard extends Wizard {
	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timeSpan) {
		
		if(fundValue > 10000 && timeSpan%2 == 0) {
			return Decision.LIQUIDATE_FUND;
		}		
		
		else if(fundValue > 20000 && timeSpan%2 != 0) {
			return Decision.LIQUIDATE_FUND;
		}
		return Decision.KEEP_FUND;
	}

}
