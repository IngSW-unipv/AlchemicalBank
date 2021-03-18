package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class Gatti468998 extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		// TODO Auto-generated method stub
		if(fundValue>=0.8*5120) {
			return Decision.LIQUIDATE_FUND;
		}
		else return Decision.KEEP_FUND;
	}

}
