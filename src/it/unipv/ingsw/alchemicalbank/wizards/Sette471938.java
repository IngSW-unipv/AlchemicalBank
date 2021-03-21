package it.unipv.ingsw.alchemicalbank.wizards;


//Gabriele Francesco Sette 


import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class Sette471938 extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if (timespan >= 10) {
			return Decision.LIQUIDATE_FUND;
		}
		else
			return Decision.KEEP_FUND;
	}

}
