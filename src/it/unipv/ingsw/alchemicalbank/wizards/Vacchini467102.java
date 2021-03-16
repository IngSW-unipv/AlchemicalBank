package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.*;

//Edoardo Vacchini (Matricola 467102)

public class Vacchini467102 extends Wizard{
	
	@Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if((fundValue > 500) && (Math.random() > 0.6))
			return Decision.LIQUIDATE_FUND;
		else
			return Decision.KEEP_FUND;
    }
}
