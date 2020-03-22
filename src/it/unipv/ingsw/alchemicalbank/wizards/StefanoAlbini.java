package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class StefanoAlbini extends Wizard {
	
	//Stefano Albini 435643
	//Alessio Bianchi 436392
	
	private int order;
	private int closingMonth;
	
	public StefanoAlbini() {
		this.order = 0;
		this.closingMonth = 9;
	}
	
	
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        this.order = order;
        
        if(yourCoins < partnerCoins) {
        	this.closingMonth = 10;
        }
        
        if(yourCoins < partnerCoins/2) {
        	this.closingMonth = 11;
        }
        
    }
	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		
		if(timespan >= closingMonth) {
			return Decision.LIQUIDATE_FUND;
		}
		
		if(order == 1 && timespan == 11) {
			return Decision.LIQUIDATE_FUND;
		}
		else return Decision.KEEP_FUND;
		
	}


}
