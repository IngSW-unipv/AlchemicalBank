/**
 * @author Amato Francesco 468497
 */

package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;


public class Amato468497_Wizard extends Wizard{

	//Informazioni del mio mago
	private long myCoins; //le mie monete
	private int  myRevenue; //il mio guadagno sulla singola giocata
	private int order, time; //chi gioca per primo ed il tempo passato (mesi)
	
	//Informazioni del mago contro cui sto attualmente giocando contro
	private long hisCoins; //monete del mago avversario
	private int hisRevenue; //guadagno del mio avversario sulla giocata
	
	
	//Metodo per decidere la strategia migliore di quando chiudere o tenere
	//aperto il fondo, per poi riuscire a vincere l'intero "tournament"
	@Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		
		if(this.order == 2 && timespan == 11)
			return Decision.LIQUIDATE_FUND;
		else if (this.order == 1 && timespan == 10)
			return Decision.LIQUIDATE_FUND;
		else if (this.order == 2 && myRevenue>hisRevenue)
			return Decision.LIQUIDATE_FUND;
		else
			return Decision.KEEP_FUND;
		
    }
	
	/* Metodi per ricavare le informazioni sulle mosse e le informazioni
	   degli altri giocatori, per poi scegliere la strategia migliore */
	@Override
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		this.myCoins = yourCoins;
		this.hisCoins = partnerCoins;
		this.order = order;
    }
	
	@Override
	public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
        this.myRevenue = yourRevenue;
        this.hisRevenue = partnerRevenue;
        this.time = time;
    }

}