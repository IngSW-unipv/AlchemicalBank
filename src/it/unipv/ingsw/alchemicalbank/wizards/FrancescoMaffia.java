package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

//Francesco Maffia 427942
public class FrancescoMaffia extends Wizard {
    
	private int order;
	private long myCoins;
	private long partnersCoins;
	
	@Override
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        this.order=order;
        myCoins=yourCoins;
        this.partnersCoins=partnerCoins;
    }
	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
	    
		if (timespan == 12 && order == 2)
			return Decision.LIQUIDATE_FUND;
		
		if (timespan == 11 && order == 1)
			return Decision.LIQUIDATE_FUND;
		
		
		int timeToClose=1;
	    int [] gainPossibleValues=new int [12];
	    
	    for(int i=0; i<12; ++i) {
	    	gainPossibleValues[i]=2^(4+i);
	    }
	    
		if(myCoins<partnersCoins)
			return Decision.KEEP_FUND;
		else {
			if(myCoins-partnersCoins>32768)
				return Decision.KEEP_FUND;
			else {
				if(order==1) {
				for(int i=1; i<12; i+=2)
					if(myCoins-partnersCoins>gainPossibleValues[i])
						timeToClose=i+2;
				}
				else {
					for(int i=0; i<12; i+=2)
						if(myCoins-partnersCoins>gainPossibleValues[i])
							timeToClose=i+2;
				}
				if(timespan!=timeToClose)
					return Decision.KEEP_FUND;
				else
					return Decision.LIQUIDATE_FUND;
			}
		}
		
	}		

}
