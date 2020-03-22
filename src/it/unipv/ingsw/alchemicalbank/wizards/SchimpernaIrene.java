package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

// Schimperna Irene matr. 458248

public class SchimpernaIrene extends Wizard {
	private int order, year;
	private long yourCoins, partnerCoins;
	private boolean wonLastYear;
	private int timeToClose;
	
	public SchimpernaIrene() {
		super();
		
		wonLastYear = true;
	}
	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(timespan >= timeToClose) {
			return Decision.LIQUIDATE_FUND;
		} else {
			return Decision.KEEP_FUND;
		}
		
	}
	
	@Override
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        this.year = year;
		this.order = order;
        this.yourCoins = yourCoins;
        this.partnerCoins = partnerCoins;
        timeToClose = timeToClose();
    }
	
	@Override
	public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
        if(yourRevenue < partnerRevenue) {
        	wonLastYear = false;
        } else {
        	wonLastYear = true;
        }
    }
	
	private int timeToClose() {
		int time = 11;
		if(order == 2) {
			time = 12;
			if(!wonLastYear) {
				time = time - 2;
			}
		}
		if(year>=3 && yourCoins > 4*partnerCoins) {
			if(order == 2)
				time = 6;
			else
				time = 7;
		}
		return time;
	}

}
