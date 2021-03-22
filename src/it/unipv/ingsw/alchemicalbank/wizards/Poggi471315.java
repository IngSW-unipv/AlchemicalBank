package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

// Alessio Poggi 471315

public class Poggi471315 extends Wizard {
	
	private int chiusura;	// indica il mese in cui si intende chiudere il conto
	
	public Poggi471315() {
		this.chiusura = 10;
	}

	
	// Metodo invocato quando il mago viene chiamato a prendere una decisione
	// I paramatri che conosciuti sono il mese attuale e il valore del fondo
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {

		// Se questo metodo viene invocato da un MAGO allora gli rispondo che terrò aperto il conto
		// Per capire se è un MAGO ad invocare questo metodo utilizzo la funzione 'callerIsWizard()'
		if(callerIsWizard()) {
			return Decision.KEEP_FUND;
		}
		else {
			// Se il mese attuale è il mese in cui intendo chiudere il conto o è il mese
			// immediatamente successivo, allora liquido il conto. Altrimenti lo lascio aperto
			if(timespan >= chiusura || timespan >= 11)
				return Decision.LIQUIDATE_FUND;
			else
				return Decision.KEEP_FUND;	 
		}
	}

	
    // Metodo invocato all'apertura di ogni nuovo conto
    // I parametri conosciuti sono l'anno attuale, l'ordine del mago, e i soldi dei due maghi
    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        /* 
         * La strategia utilizzata consiste nel calcolare il mese al quale liquidare il conto all'apertura di ogni nuovo conto.
         * Il mese in cui vorremmo idealmente chiudere il conto è il mese immediatamente precedente a quello in cui avrebbe chiuso il partner.
         * Per fare una stima del mese in cui chiuderà il partner:
         * 		1) calcoliamo il rapporto: ( (partnerCoins-100) / year) + 5 -> il risultato è all'incirca una potenza di 2 
         * 			(il '+5' somma i soldi spesi ogni anno per aprire il conto e il '-100' è il deposito iniziale dato dalla banca)
         * 		2) calcoliamo il logaritmo in base 2 del risultato ottenuto al punto 1) e gli sottraiamo 3 per ottenere il mese medio di chiusura: log2(...)-3
         * 		3) NB: per assicurarmi di chiudere il conto sempre prima del partner dovrei sottrarre 1 al risultato ottenuto ogni volta in cui il risultato è dispari e io
         * 				sono il mago pari, oppure quando il risultato è pari e io sono il mago dispari. Ma decido di non farlo perchè tengo in conto che la media calcolata
         * 				non è precisissima ma risulta piu piccola (in difetto) rispetto all'effetiva scelta del partner. Questo perchè la media calcolata non tiene conto solo 
         * 				delle scelte del nostro partner ma anche delle scelte che sono state fatte da altri contro di lui.
         */

    	try {
    		chiusura = log2( ( (partnerCoins-100)/(year-1) +5) ) -3;
    	} catch (ArithmeticException e) {
    		//System.err.println(e.getMessage());
    	}
    }

    
    // Metodo per calcolare il logaritmo in base 2 di un numero 'n'
    // Il valore di ritorno è intero perchè rappresenta un mese dell'anno
    private int log2(double n) { 

    	// calcolo del logaritmo in base 2 usando le regole dei logaritmi; arrotondo e restituisco il risultato
    	int result = (int) Math.round( (Math.log(n) / Math.log(2)) );
    	return result; 
    }
    
    
    /*
     *  Questo metodo serve per ottenere il nome completo della classe che ha invocato 'il metodo che invoca questo metodo'
     *  Dopo aver ottenuto la stringa d'interesse (esempio: "it.unipv.ingsw.alchemicalbank.wizards.Poggi471315") la divido
     *  in sottostringhe separate dal punto '.' e infine controllo se la quinta stringa è uguale a 'wizards'. Se così fosse
     *  significa che è un mago ad aver invocato il metodo 'askKeepOrLiquidate' di questa classe, per cui ritorno true altrimenti ritorno false.
     */
	private boolean callerIsWizard() {
		String caller = Thread.currentThread().getStackTrace()[3].getClassName();
		String[] splitCaller = caller.split("\\.");

		try {
			if(splitCaller[4].equals("wizards"))
				return true;
		} catch (ArrayIndexOutOfBoundsException e) {
			//System.err.println(e.getMessage());
		}
		return false;
	}
}
