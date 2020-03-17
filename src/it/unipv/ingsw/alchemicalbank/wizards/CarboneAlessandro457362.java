package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;


// Alessandro Carbone, matr. 457362


public class CarboneAlessandro457362 extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		// TODO Auto-generated method stub
		if(fundValue<500)
			return Decision.KEEP_FUND;
		else
			return Decision.LIQUIDATE_FUND;
	}

}
