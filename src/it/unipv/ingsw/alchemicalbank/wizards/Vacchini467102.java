package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.*;

//Edoardo Vacchini (Matricola 467102)

public class Vacchini467102 extends Wizard{
	private long myCoins, hisCoins;
	private int order, time, myRevenue, hisRevenue, year;
	
	private int avgClosingTimeOfPartner, timesClosedByPartner;
	
	@Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(this.year == 1) {
			this.avgClosingTimeOfPartner = 0;
			this.timesClosedByPartner = 0;
		}
		
		
		
		if(timespan == 10 && timespan == 11)
			return Decision.LIQUIDATE_FUND;
		else
			return Decision.KEEP_FUND;
    }
	
	@Override
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		this.myCoins = yourCoins;
		this.hisCoins = partnerCoins;
		this.order = order;
		this.year = year;
    }
	
	@Override
	public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
        this.myRevenue = yourRevenue;
        this.hisRevenue = partnerRevenue;
        this.time = time;
        // stimo il tempo medio di chiusura del partner (utile se questo ha una strategia basata
        // sulla soglia o sul valore del fondo).
        if(((time % 2 == 0) && (this.order == 1))||((this.order == 2)&&(time %2 == 1))) { 
        	this.timesClosedByPartner++;
        	this.avgClosingTimeOfPartner *= (this.timesClosedByPartner-1)/this.timesClosedByPartner;
        	this.avgClosingTimeOfPartner += (time/this.timesClosedByPartner);
        }else
        	return;
    }
}
