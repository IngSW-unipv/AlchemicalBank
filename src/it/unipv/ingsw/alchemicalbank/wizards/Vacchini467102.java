package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.*;

//Edoardo Vacchini (Matricola 467102)

public class Vacchini467102 extends Wizard{
	
	@Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(timespan == 11 || timespan == 10)
			return Decision.LIQUIDATE_FUND;
		else if((fundValue > 100) && (Math.random() > 0.6))  // soglia minima con tendenza al rischio
			return Decision.LIQUIDATE_FUND;
		else
			return Decision.KEEP_FUND;
    }
}
