package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class AndreaGiorgi extends Wizard {

	private boolean forceClose = false;
	private boolean forceCloseBadTrader = false;
	private boolean amIFirst;

	@Override
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		// TODO Auto-generated method stub
		super.newFund(year, order, yourCoins, partnerCoins);
		if (order == 1)
			amIFirst = true;
		else
			amIFirst = false;
		if (year > 10) {
			if (partnerCoins / year > 6600)
				forceClose = true;
			if (1.75*partnerCoins / year < yourCoins)
				forceCloseBadTrader = true;
		}

	}


	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if (fundValue < 16384)
			return Decision.KEEP_FUND;
		if (forceClose == true && timespan > 7) {
			forceClose = false;
			return Decision.LIQUIDATE_FUND;
		}
		if (forceCloseBadTrader = true) {
			forceCloseBadTrader = false;
			return Decision.LIQUIDATE_FUND;
		}
		return Decision.LIQUIDATE_FUND;
	}

}
