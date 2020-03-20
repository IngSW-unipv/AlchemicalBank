package it.unipv.ingsw.alchemicalbank.wizards;

import java.security.Timestamp;
import java.util.ArrayList;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

//Angelica Seiberl 457995

public class AngelicaSeiberl extends Wizard {
	
	
	private int order;

	@Override
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		// TODO Auto-generated method stub
		super.newFund(year, order, yourCoins, partnerCoins);
		this.order = order;
	}
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		// TODO Auto-generated method stub
		if(this.order == 2 ) {
			if(timespan == 10) {
				return Decision.LIQUIDATE_FUND;
			}
		
			return Decision.KEEP_FUND;
		}
		else if(timespan == 11) {
			return Decision.LIQUIDATE_FUND;
		}
		
		return Decision.KEEP_FUND;
	}
	



	
}
