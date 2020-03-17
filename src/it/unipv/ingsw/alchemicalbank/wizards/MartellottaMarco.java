package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

/*
 * Marco Martellotta
 * n. matricola: 458612
 */

public class MartellottaMarco extends Wizard {
	
	private boolean ifFirst = false;
	private boolean if1 = false;

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
	
		if (if1) {
			if(ifFirst && (timespan <= 10)) {
				return Decision.KEEP_FUND;
			} else if (!ifFirst && (timespan <= 9)) {
				return Decision.KEEP_FUND;
			} else { 
				return Decision.LIQUIDATE_FUND;
			}
		}
		
		if(ifFirst && (timespan <= 7)) {
			return Decision.KEEP_FUND;
		} else if (!ifFirst && (timespan <= 7)) {
			return Decision.KEEP_FUND;
		} else { 
			return Decision.LIQUIDATE_FUND;
		}
		
	}
	
	public void newFund (int year, int order, long yourCoins, long partnerCoins) {
		if (order == 1) {
			ifFirst = true;
		}
		if (yourCoins > 2*partnerCoins) {
			if1 = true;
		}
	}

}
