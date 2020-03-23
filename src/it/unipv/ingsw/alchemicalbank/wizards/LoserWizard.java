package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class LoserWizard extends Wizard {
	private int order;

	public LoserWizard() {
		super();
	}

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {

		if (this.order == 1) {
			if(fundValue > 15000 && timespan > 4)
				return Decision.LIQUIDATE_FUND;
			else
				return Decision.KEEP_FUND;
		}
		if (this.order == 2) {

			return Decision.KEEP_FUND;

		}

		return Decision.KEEP_FUND;

	}

	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		this.order = order;
	}

}
