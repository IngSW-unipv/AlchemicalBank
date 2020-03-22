package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

// Frenkli Buzhiqi

public class FrenkliBuzhiqi extends Wizard{
	
	private int myOrder;

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(fundValue > 15000 && timespan > 4) {
			if(myOrder == 2) {
				return Decision.KEEP_FUND;
			} else {
			return Decision.LIQUIDATE_FUND;
		    }
		} else {
			return Decision.KEEP_FUND;
		}
	}
	
	  public void newFund(int year, int order, long yourCoins, long partnerCoins) {
	        this.myOrder = order;
	    }

}
