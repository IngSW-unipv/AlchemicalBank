package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class PratiAndrea extends Wizard {

	private int lastYear;
	private int actualYear;
	private int actualOrder; //ordine che il mio mago ha quell'anno li
	private long actualMyCoins;
	private long actualPartnerCoins;
	/*
	 * Con questa variabile so in che mese dell'anno sono, viene incrementata di mese in mese
	 */
	private int mesiTotali;
	
	/**
	 * Questo parametro serve solo a tenere d'occhio com'è andato nel tempo il mio mago,
	 * se tutto funziona ad ogni gara questo contatore mi dice quante volte il mio mago ha preso
	 * una decisione che ha portato il suo socio di conto a vincere più soldi di lui
	 */
	private int contatoreBrutteAnnate;
	
	public PratiAndrea() {

		lastYear = 0;
		actualYear = 0;
		actualOrder = 0; //ordine che il mio mago ha quell'anno li
		actualMyCoins = 0;
		actualPartnerCoins = 0;
		mesiTotali = 0;
		contatoreBrutteAnnate = 0;
		
	}
	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
	
		boolean mesePari = (timespan % 2) == 0;
		int tempo = 10;
		
		if(timespan >= tempo) {
			
			if(this.isMyTurn(mesePari)) {
				
				return Decision.LIQUIDATE_FUND;
				
			}
			
		}
		
		if((actualMyCoins / actualPartnerCoins) >= 2) {
			
			if(actualOrder == 1) {
				tempo = 11;
				return Decision.KEEP_FUND;
				
			}
			
			if(timespan >= (tempo-2)) {
				
				if(this.isMyTurn(mesePari)) {
					
					return Decision.LIQUIDATE_FUND;
				}
				
			}
			
		}

		return Decision.KEEP_FUND;

	}
	

	/**
	 * Metodo che mi dice se è il mio turno o meno
	 * @param mesePari - true se è un mese pari
	 * @return true se è il mio turno
	 */
	private Boolean isMyTurn(boolean mesePari) {

		if(mesePari && (actualOrder == 2)) {
			
			return true;
			
		} else if(!mesePari && actualOrder == 1) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}

	@Override
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		
		this.actualYear = year;
		this.actualOrder = order;
		this.actualMyCoins = yourCoins;
		this.actualPartnerCoins = partnerCoins;
				
	}

	@Override
	public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
		
		
		if(yourRevenue < partnerRevenue) {
			
			this.contatoreBrutteAnnate += 1;
			
		}
		
	}
	
}
