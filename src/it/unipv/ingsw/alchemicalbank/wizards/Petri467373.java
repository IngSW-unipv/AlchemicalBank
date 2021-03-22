package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class Petri467373 extends Wizard {

	private int order;

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(timespan == 11 && fundValue > 2000) {
			return Decision.LIQUIDATE_FUND;
		} else if(order == 2 && timespan == 10){ //se non ho priorità
			return Decision.LIQUIDATE_FUND;
		}
		else return Decision.KEEP_FUND;

	}

}

//patient wizard lascia sempre aperto!! wackyWizard chiude subito!!