package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

//Studente: Alessandro Terracciano
//Mat. n� 467144

public class Terracciano467144 extends Wizard {
	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		// TODO Auto-generated method stub
		if(timespan>10)
		{
			return Decision.LIQUIDATE_FUND;
		}
		else
		{
			return Decision.KEEP_FUND;
		}
	}

}
