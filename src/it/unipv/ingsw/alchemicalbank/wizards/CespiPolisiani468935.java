package it.unipv.ingsw.alchemicalbank.wizards;


import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class CespiPolisiani468935 extends Wizard {
	
	private int actualYear;
	
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		this.actualYear = year;
	}
	
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if ((this.actualYear < 70) && timespan >= 11) {
			return Decision.LIQUIDATE_FUND;
		} else if ((this.actualYear > 70) && (timespan > 6)) {
			return Decision.LIQUIDATE_FUND;
		} else {
			return Decision.KEEP_FUND;
		}
	}
	

}
