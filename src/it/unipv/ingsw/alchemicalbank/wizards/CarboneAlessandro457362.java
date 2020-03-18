package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;


// Alessandro Carbone, matr. 457362


public class CarboneAlessandro457362 extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		// TODO Auto-generated method stub
		if((fundValue<=2043 && (timespan%2)==0) || timespan<=8)
			return Decision.KEEP_FUND;
		else if(fundValue<4091 && (timespan%2)!=0)
			return Decision.KEEP_FUND;
		else
			return Decision.LIQUIDATE_FUND;
	}
}