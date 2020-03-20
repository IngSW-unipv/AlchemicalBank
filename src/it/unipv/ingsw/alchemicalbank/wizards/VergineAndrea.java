package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

// Vergine Andrea

public class VergineAndrea extends Wizard {
	int numMago=0;
	
	public VergineAndrea() {
		// TODO Auto-generated constructor stub
	}
	
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		this.numMago=order;
	}
	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(numMago == 1) {
			if(timespan<10) return Decision.KEEP_FUND;
			else return Decision.LIQUIDATE_FUND;
		} else {
			if(timespan<11) return Decision.KEEP_FUND;
			else return Decision.LIQUIDATE_FUND;
		}
	}

}
