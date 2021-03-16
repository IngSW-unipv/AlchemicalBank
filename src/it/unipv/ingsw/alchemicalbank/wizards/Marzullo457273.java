package it.unipv.ingsw.alchemicalbank.wizards;

<<<<<<< HEAD

=======
>>>>>>> 80058a9f70d0b5a9b1423ddfc573d225f56b21f5

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

// Francesco Marzullo

public class Marzullo457273 extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		// TODO Auto-generated method stub
		if (fundValue > 1600 || timespan > 7) {
			return Decision.LIQUIDATE_FUND;
		} else {
			return Decision.KEEP_FUND;
		}
	}
}
