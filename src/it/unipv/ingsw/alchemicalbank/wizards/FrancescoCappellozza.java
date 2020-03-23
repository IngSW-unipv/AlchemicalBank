package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

//Francesco Cappellozza 454101

public class FrancescoCappellozza extends Wizard{
	int year;
	long yourCoins, partnerCoins;
	
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		this.yourCoins=yourCoins;
		this.partnerCoins=partnerCoins;
        this.year = year;
    }
	
	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(year>3	||	yourCoins == partnerCoins+170) {
			return Decision.KEEP_FUND;
		}else {
			return Decision.LIQUIDATE_FUND;
		}
	}

}
