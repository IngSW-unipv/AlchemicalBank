package it.unipv.ingsw.alchemicalbank.wizards;

import java.util.Random;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class StefanausMeravigliaus extends Wizard {

	// stefano butera 457744 
	
	public StefanausMeravigliaus() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(fundValue>6000) {
			return Decision.LIQUIDATE_FUND;
			
		}
	
			if(timespan == 11 && fundValue >5000) {
				return Decision.LIQUIDATE_FUND;
			}
						
			
			return Decision.KEEP_FUND;
			
			
			
	}

}
