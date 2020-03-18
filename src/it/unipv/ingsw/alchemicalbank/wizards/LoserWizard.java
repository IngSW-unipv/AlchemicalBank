package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class LoserWizard extends Wizard {
	private long mcoin;
	private long ycoin;
	private int start;

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if (start == 1) {
			if (fundValue>15000) {
				return Decision.LIQUIDATE_FUND;
			}
			return Decision.KEEP_FUND;
			
		} else {
			if (timespan ==10) {
				return Decision.LIQUIDATE_FUND;
			}
			return Decision.KEEP_FUND;
		}

	}

	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		start = order;
		mcoin = yourCoins;
		ycoin = partnerCoins;
	}

}
