package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class Paperino extends Wizard {
	
	
	//Variabili per gestione degli anni
	private int wichYearIsNow = 0;
	private int lastTimespanIveKeep = 0;
	private int firstTimeInTheYear = 0;
	private int firstYear = 0;
	
	
	//Variabili per quale mago e tot soldi
	private int qualeMagoSono=0; //1 o 2, riferito al singolo anno
	private int totalGainTillNow = 0; //La somma delle vincite fatte nell'anno
	private int quantoDovevoGuadagnareFinoAlTurnoPrecedente = 0;
	private int x = 0; //Numero di volte che mi hanno chiuso la porta in faccia * 2
	
	
	@Override
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		// TODO Auto-generated method stub
		qualeMagoSono = order;		
		//Ho la totalità dei miei soldi e di quelli dell'avversario
	}
	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		// TODO Auto-generated method stub
		//Devo capire se l'altro ha dismesso
	
		if(firstYear != 0 && lastTimespanIveKeep < timespan) {
			firstTimeInTheYear = 0; // Vuol dire che è il nuovo anno per me
									// dopo che mi hanno chiuso la porta in faccia
		}
		
		//Logica se sono il primo mago
		if(qualeMagoSono == 1 && timespan == (7 + x) ) {
			return Decision.LIQUIDATE_FUND;
		}

		//Logica se sono il secondo mago
		if(qualeMagoSono == 2 && timespan == (8)  ) {
			return Decision.LIQUIDATE_FUND;
		}
		
		return Decision.KEEP_FUND;
	}
	
	
	
	@Override
	public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
		// TODO Auto-generated method stub
		totalGainTillNow += yourRevenue;
		wichYearIsNow++;
		if(yourRevenue < partnerRevenue) {
			x += 2;
			if(x >= 6)
				x = 0;
		}		
	}
	
	
	

}
