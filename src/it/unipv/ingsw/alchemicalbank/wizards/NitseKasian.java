package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;
//Kasian-Andriy Nitse 

public class NitseKasian extends Wizard {
    public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
        /* Do nothing */
    }
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if (fundValue<16384)
			return Decision.KEEP_FUND;
		else
			return Decision.LIQUIDATE_FUND;
	}
}
