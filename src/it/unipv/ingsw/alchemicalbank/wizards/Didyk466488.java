package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

// Didyk Iryna

public class Didyk466488 extends Wizard{


		@Override
		public Decision askKeepOrLiquidate(int fundValue, int timespan) {
			if(timespan == 11 && fundValue > 2000) {
				return Decision.LIQUIDATE_FUND;
			} else {
				return Decision.KEEP_FUND;
			}
		}

}
