package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class Diegoli472668 extends Wizard {
	
	int year;

	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		
		 if (year == 1)
             return Decision.KEEP_FUND;
         if (timespan > 10)
             return Decision.LIQUIDATE_FUND;
         else
             return Decision.KEEP_FUND;
				
	}
	
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		this.year = year;
    }

}
