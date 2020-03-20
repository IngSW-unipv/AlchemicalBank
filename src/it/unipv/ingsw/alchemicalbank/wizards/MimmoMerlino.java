package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

//Domenico Ragusa 454220 🧙🏻‍♂

public class MimmoMerlino extends Wizard {
	private int mioOrdine;
	private boolean differenza;
	
	@Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		mioOrdine=order; //ottengo il mio ordine di scelta
		
		if(yourCoins > 2.3*partnerCoins) //cerco di capire se posso rischiare guardando la differenza tra i guadagni del mio mago e quelli dell'avversario
			differenza=true; 
		else 
			differenza=false;
	}

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(fundValue > 16383) //se si arriva oltre l'11o mese chiudo il prima possibile
			return Decision.LIQUIDATE_FUND;
		
			if(differenza) { //se c'è molta differenza l'avversario chiude presto quindi provo ad anticiparlo chiudendo al 7o o all'8o mese (prima i guadagni sarebbero comunque bassi)
				if((mioOrdine==1 && timespan==7) | (mioOrdine==2 && timespan==8))
					return Decision.LIQUIDATE_FUND;
			}
			
		return Decision.KEEP_FUND; //decisione di default se non si verificano le condizioni sopra
	}
}
