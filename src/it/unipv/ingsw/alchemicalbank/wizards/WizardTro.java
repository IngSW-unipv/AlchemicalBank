package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;


// Trovato Giada

public class WizardTro extends Wizard {
	//metodo inviocato e ci chiede se voglio aprire o chiudere il fondo.
	// conosco il valore del fondo e la data  di apertura 
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(fundValue<100) 
			 	return Decision.KEEP_FUND;
			else 
				return Decision.LIQUIDATE_FUND;
		
	}

}
