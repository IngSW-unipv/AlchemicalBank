package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class Ariola460828 extends Wizard{

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if (fundValue > 160 && timespan == 12) {

			return Decision.LIQUIDATE_FUND;
		} 
		else {
			return Decision.KEEP_FUND;
		}
	}
		

}
