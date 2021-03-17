package it.unipv.ingsw.alchemicalbank.wizards;
import it.unipv.ingsw.alchemicalbank.*;

public class Bottini471395 extends Wizard{
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		//Bottini471395
		if(timespan==12) {
			return Decision.LIQUIDATE_FUND;
		} else {
			return Decision.KEEP_FUND;
		}
	}
}
