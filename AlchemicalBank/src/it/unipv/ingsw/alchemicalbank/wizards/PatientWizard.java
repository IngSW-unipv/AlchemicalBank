package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

/**
 * A wizard that wants to wait for a lot of money.
 */
public class PatientWizard extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		return Decision.KEEP_FUND;
	}

}
