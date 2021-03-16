package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class Rognoni466593 extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		// TODO Auto-generated method stub
		if(timespan >= 10) {
			return Decision.LIQUIDATE_FUND;
		}else {
			return Decision.KEEP_FUND;
		}
	}

	@Override
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		// TODO Auto-generated method stub
		super.newFund(year, order, yourCoins, partnerCoins);
	}

	@Override
	public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
		// TODO Auto-generated method stub
		super.fundClosed(time, yourRevenue, partnerRevenue);
	}

}
