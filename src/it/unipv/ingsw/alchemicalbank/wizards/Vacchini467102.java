package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.*;

//Edoardo Vacchini (Matricola 467102)

public class Vacchini467102 extends Wizard{
	private long myCoins, hisCoins;
	private int order, time, myRevenue, hisRevenue;
	
	
	@Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(this.order == 1 && timespan == 11)
			return Decision.LIQUIDATE_FUND;
		else if (this.order == 2 && timespan == 10)
			return Decision.LIQUIDATE_FUND;
		else
			return Decision.KEEP_FUND;
    }
	
	@Override
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		this.myCoins = yourCoins;
		this.hisCoins = partnerCoins;
		this.order = order;
    }
	
	@Override
	public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
        this.myRevenue = yourRevenue;
        this.hisRevenue = partnerRevenue;
        this.time = time;
    }
}
