package it.unipv.ingsw.alchemicalbank.wizards;
import it.unipv.ingsw.alchemicalbank.*;

public class Bottini471395 extends Wizard{
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(fundValue>4000 && timespan>=6) {
			return Decision.LIQUIDATE_FUND;
		} else {
			return Decision.KEEP_FUND;
		}
	}
	

}
