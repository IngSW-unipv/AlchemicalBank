package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class Paredes460294 extends Wizard{

	//Paredes Chacon Percy Jesus 460294

	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if (timespan == 12) {
			return Decision.LIQUIDATE_FUND;
		}else {
			return Decision.KEEP_FUND;
		}
	}
	
	

}
