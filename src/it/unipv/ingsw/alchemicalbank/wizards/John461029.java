package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class John461029 extends Wizard{

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(timespan == 12){
			return Decision.LIQUIDATE_FUND;
		} else {
			return Decision.KEEP_FUND;
		}
		// TODO Auto-generated method stub
	
	} 

}
