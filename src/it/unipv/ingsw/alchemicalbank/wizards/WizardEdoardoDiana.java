package it.unipv.ingsw.alchemicalbank.wizards;

import java.util.Random;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

//Edoardo Diana  458487

public class WizardEdoardoDiana extends Wizard {

	 private Random randomGenerator = new Random();
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(((fundValue/550)*20)>=250) {
			if (randomGenerator.nextBoolean())
					return Decision.KEEP_FUND;
	        	else
	        		return Decision.LIQUIDATE_FUND;
		}else
			return Decision.KEEP_FUND;
	}

}
