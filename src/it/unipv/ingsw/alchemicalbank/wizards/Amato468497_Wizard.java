package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

//Wizard: AmatoFrancesco 468497

public class Amato468497_Wizard extends Wizard{

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		
		if ((fundValue > 100) || (timespan>6))
				return Decision.LIQUIDATE_FUND;
		else if ((fundValue<=100) || (timespan<5))
			return Decision.KEEP_FUND;
		else return Decision.LIQUIDATE_FUND;
		
	}

}