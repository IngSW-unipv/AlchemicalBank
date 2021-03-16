package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;
/**
 * 
 * @author Paolo Falzone, 473685
 *
 */
public class Falzone473685 extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		//prova
		return Decision.KEEP_FUND;
	}

}
