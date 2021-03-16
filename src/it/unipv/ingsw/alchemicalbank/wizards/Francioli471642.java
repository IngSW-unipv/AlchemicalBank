package it.unipv.ingsw.alchemicalbank.wizards;

// @author Francioli Lucia 471642
import it.unipv.ingsw.alchemicalbank.*;

public class Francioli471642 extends Wizard {
	
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if (fundValue > 100) {
			return Decision.LIQUIDATE_FUND;
		} else {
			return Decision.KEEP_FUND;
		}
		
	} 

}
