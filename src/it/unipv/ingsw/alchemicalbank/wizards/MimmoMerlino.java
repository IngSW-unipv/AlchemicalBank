package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

//Domenico Ragusa 454220

public class MimmoMerlino extends Wizard {
	private int mioOrdine;
	private boolean chiudeBasso=false;
	int differenza=0;
	
	@Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		mioOrdine=order;
		
		if(yourCoins > 2.5*partnerCoins)
			differenza=1;
		else
			differenza=0;
		
		if(partnerCoins <= (year-1)*800)
			chiudeBasso=true;
	}
	
	@Override
	 public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
    }

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(fundValue > 16383)
			return Decision.LIQUIDATE_FUND;
		
		if(chiudeBasso) {
			if(differenza==1) {
				if(mioOrdine==1 && timespan==7)
					return Decision.LIQUIDATE_FUND;
				else if(mioOrdine==2 && timespan==8)
					return Decision.LIQUIDATE_FUND;
			}else if(differenza==0) {
				if(mioOrdine==1 && timespan==6)
					return Decision.LIQUIDATE_FUND;
				else if(mioOrdine==2 && timespan==7)
					return Decision.LIQUIDATE_FUND;
			}else {
				return Decision.KEEP_FUND;
			}
		}else if(!chiudeBasso) {
			if(differenza==1) {
				if(mioOrdine==1 && timespan==9)
					return Decision.LIQUIDATE_FUND;
				else if(mioOrdine==2 && timespan==10)
					return Decision.LIQUIDATE_FUND;
			}else if(differenza==0){
				if(mioOrdine==1 && timespan==7)
					return Decision.LIQUIDATE_FUND;
				else if(mioOrdine==2 && timespan==8)
					return Decision.LIQUIDATE_FUND;
			}else
					return Decision.KEEP_FUND;
			}else
				return Decision.KEEP_FUND;
		return Decision.KEEP_FUND;
	}
}
