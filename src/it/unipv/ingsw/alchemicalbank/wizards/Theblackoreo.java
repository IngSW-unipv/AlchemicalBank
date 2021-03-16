package it.unipv.ingsw.alchemicalbank.wizards;

import java.util.List;
import java.util.Map;

import it.unipv.ingsw.alchemicalbank.Bank;
import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class Theblackoreo extends Wizard {

	//TAGLIANI FABIO 472089
	
	public Bank b;

	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		
		
		if(timespan == 10 || timespan == 11) {
			
			return Decision.LIQUIDATE_FUND;
		}
		
		else {
			
			return Decision.KEEP_FUND;
		}
		
	}
	
	
	
	

}
