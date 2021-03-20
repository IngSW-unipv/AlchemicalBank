/**
 * @author Amato Francesco 468497
 */

package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;


public class Amato468497_Wizard extends Wizard{

	// Indica quale tra i giocatori tocca decidere se chiudere il conto
	private int order;
	
	//Metodo per decidere la strategia migliore di quando chiudere o tenere
	//aperto il fondo, per poi riuscire a vincere l'intero "tournament"
	@Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		
		/* Provo a massimizzare il mio profitto, in base a chi toccherà
		* la scelta di chiudere il conto il prossimo mese */
		
		// Se mi trovo nel mese 11 e la prossima volta il giocatore 2 
		// chiuderà il fondo (al 12 mese il fondo viene chiuso in base alle
		// regole del gioco) allora chiudo io per primo
		if ((order++==2) && (timespan==11))
			return Decision.LIQUIDATE_FUND;
		// Se mi trovo nel mese 10 e al prossimo turno toccherà decidere
		// se chiudere all'altro giocatore, è abbastanza ragionevole che
		// chiuda prima di lui, altrimenti si intasca più soldi lui
		else if ((order++==2) && (timespan==10)) 
			return Decision.LIQUIDATE_FUND;
		// Viceversa continuo a tenere aperto il conto
		else return Decision.KEEP_FUND;
    }
	
	/* Metodi per ricavare le informazioni sulle mosse e le informazioni
	   degli altri giocatori, per poi scegliere la strategia migliore */
	@Override
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		this.order = order;
    }
}