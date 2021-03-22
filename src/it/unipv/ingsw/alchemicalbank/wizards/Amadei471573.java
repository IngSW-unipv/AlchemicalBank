package it.unipv.ingsw.alchemicalbank.wizards;


import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class Amadei471573 extends Wizard {
	
	private int myorder;
	private int time;
	
	
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		
		this.myorder= order;
	}
	
	public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
	        
		this.time=time;
	}
	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		
		if(timespan>=11) {
		
			return Decision.LIQUIDATE_FUND;
		}
		else return Decision.KEEP_FUND;
	}
}