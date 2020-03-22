package it.unipv.ingsw.alchemicalbank.wizards;

import java.util.Random;
import it.unipv.ingsw.alchemicalbank.Decision;

import it.unipv.ingsw.alchemicalbank.Wizard;


// Tagliaferri Filippo 459259


public class TagliaferriFilippo extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		 Random random = new Random();
		if (timespan % 2 != 0 ){
			return Decision.KEEP_FUND;
		}else if (random.nextBoolean()){
			return Decision.KEEP_FUND;
		}else{
			return Decision.LIQUIDATE_FUND;
		}
	}

}
