package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

// Francesco Maffia 427942
public class FrancescoMaffia extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if (fundValue<28000)
			return Decision.KEEP_FUND;
		else 
			return Decision.LIQUIDATE_FUND;
	}

}
