package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

//Domenico Ragusa 454220 🧙🏻‍♂

public class MimmoMerlino extends Wizard {
	private int mioOrdine;
	private boolean chiudeBasso=false, differenza;
	
	@Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		mioOrdine=order; //ottengo il mio ordine di scelta
		
		if(yourCoins > 2.5*partnerCoins) //cerco di capire se posso rischiare guardando la differenza tra i guadagni del mio mago e quelli dell'avversario
			differenza=true; 
		else 
			differenza=false;
		
		if(partnerCoins <= (year-1)*800) //cerco di capire se l'avversario è uno che tende a chiudere presto il conto
			chiudeBasso=true;
	}

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(fundValue > 16383) //se si arriva oltre l'11o mese chiudo il prima possibile
			return Decision.LIQUIDATE_FUND;
		
		if(chiudeBasso) { //se l'avversario è un tipo che tende a chiudere subito...
			if(differenza==true) { //se c'è molta differenza provo a rischiare chiudendo dopo la metà dell'anno
				if((mioOrdine==1 && timespan==7) | (mioOrdine==2 && timespan==8))
					return Decision.LIQUIDATE_FUND;
			}else{ //altrimenti provo a chiudere prima, sempre dopo la metà dell'anno (prima i guadagni sono molto bassi)
				if((mioOrdine==1 && timespan==6) | (mioOrdine==2 && timespan==7))
					return Decision.LIQUIDATE_FUND;
			}
		}else{ //se non è un tipo che chiude subito...
			if(differenza==true) { //se c'è molta differenza cerco di avvicinarmi ai mesi più alti
				if((mioOrdine==1 && timespan==9) | (mioOrdine==2 && timespan==10))
					return Decision.LIQUIDATE_FUND;
			}else{ //altrimenti cerco di anticiparlo
				if((mioOrdine==1 && timespan==7) | (mioOrdine==2 && timespan==8))
					return Decision.LIQUIDATE_FUND;
			}
		}
		return Decision.KEEP_FUND; //decisione di default se non si verificano le condizioni sopra
	}
}
