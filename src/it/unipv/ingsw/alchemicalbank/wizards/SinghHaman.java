package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

/**
 * @author Haman Singh 457547
 *
 */

public class SinghHaman extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		return fundValue>15000?Decision.LIQUIDATE_FUND:Decision.KEEP_FUND;
	}

}
