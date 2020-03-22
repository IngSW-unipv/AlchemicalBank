package it.unipv.ingsw.alchemicalbank.wizards;

import java.util.Random;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

// Danilo Modica 456638

public class ModicaDanilo extends Wizard {

	private boolean firstWizard;
	private Random randomGenerator;

	@Override
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		super.newFund(year, order, yourCoins, partnerCoins);
		if (order == 1)
			firstWizard = true;
		else
			firstWizard = false;
	}
	
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {	
		randomGenerator = new Random(timespan * fundValue);
		
		if (firstWizard)
			if (fundValue > 5000)
				if (randomGenerator.nextBoolean())
					return Decision.LIQUIDATE_FUND;
				else
					return Decision.KEEP_FUND;
			else
				return Decision.KEEP_FUND;
		
		else
			if (timespan == 10)
				return Decision.LIQUIDATE_FUND;
			else
				return Decision.KEEP_FUND;
	}
}
