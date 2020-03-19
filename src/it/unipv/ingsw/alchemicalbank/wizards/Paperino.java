package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class Paperino extends Wizard {
	

	
	
	//Variabili per quale mago e tot soldi
	private int qualeMagoSono=0; //1 o 2, riferito al singolo anno
	private int x = 0; //
	
	
	@Override
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		
		qualeMagoSono = order;		
		
		
		//Se la sono molto più ricco dell'altro, è più intelligente, continuare a tentare fino al masssimo, anche
		//se perdo, avrò comunque vinto io e sarò salito di più

		long diff =  yourCoins - partnerCoins;
		
		if(diff < 0)
			diff *= -1;
		
		if(0 <diff &&   diff < 1000)
			x=5;
		else if(0 <diff && diff < 2000)
			x=4;
		else if(0 <diff && diff < 3000)
			x=3 ;
		else if(0 <diff && diff < 10000)
			x=2;
		else if(0 < diff && diff < 30000)
			x=1;
		else
			x=1;
		
	}
	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		// TODO Auto-generated method stub
		//Devo capire se l'altro ha dismesso
		
		//Logica se sono il primo mago
		if(qualeMagoSono == 1 && timespan >= (11 - x) ) {
			return Decision.LIQUIDATE_FUND;
		}

		//Logica se sono il secondo mago
		if(qualeMagoSono == 2 && timespan >= (12 - x )  ) {
			return Decision.LIQUIDATE_FUND;
		}
		
		return Decision.KEEP_FUND;
	}
	
	
	
	@Override
	public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
		// TODO Auto-generated method stub
	}
	
	
	

}
