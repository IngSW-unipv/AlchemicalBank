package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class Petri467373 extends Wizard {

	//Primo tentativo basato sul timespan
	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) { //metodo che ci chiede la banca, se vogliamo aprirlo o chiuderlo
		if (timespan == 11) {              //scelgo un timespan quasi al limite
			return Decision.LIQUIDATE_FUND;
		} else {
			return Decision.KEEP_FUND;
		}
		
	}

}


//patient wizard lascia sempre aperto!! wackyWizard chiude subito!!