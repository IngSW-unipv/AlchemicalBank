package it.unipv.ingsw.alchemicalbank.wizards;


//Gabriele Francesco Sette 


import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class Sette471938 extends Wizard {

	@Override
	
	/* Cerco semplicemente di aspettare il piu` possibile per ottenere 
	 *  il massimo profitto possibile. Ragionevolmente non riusciro` mai
	 *  a chiudere all'ultimo mese, il che comporterebbe perdere circa 4k monete,
	 *  motivo per cui se se sono primo a 
	 *  cerco di chiudere all'undicesimo, se sono secondo chiudo al decimo.
	 *  
	 *  NONOSTANTE CIO` SONO DIETRO QUELLI CHE CHIUDONO SEMPRE ALL'UNDICESIMO.
	 *  Motivo per cui, noto che ci sono diversi wizard che aspettano il dodicesimo round,
	 *  anche se sono primi a scegliere e da primi non chiudono mai,
	 *  e spero di avere la fortuna di giocare con loro.
	*/
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if (timespan > 10) {
			return Decision.LIQUIDATE_FUND;
		}
		else
			return Decision.KEEP_FUND;
	}

}
