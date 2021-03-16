package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

//Aiman Al Masoud 472462

public class AimanAlMasoud472462 extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		//fundValue can be derived from timespan.
		
		//if fund is old enough, liquidate fund
		if(timespan>=6) {
			return Decision.LIQUIDATE_FUND;
		}
		
		//else if fund is too young, keep it
		return Decision.KEEP_FUND;
		
		
	}

}
