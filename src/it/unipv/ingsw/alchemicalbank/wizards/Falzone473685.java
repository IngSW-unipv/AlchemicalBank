package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;
/**
 * 
 * @author Paolo Falzone, 473685
 *
 */
public class Falzone473685 extends Wizard {

	private long myCoins; //le mie monete totali 
	private long partnerCoins; //le monete del partner
	private int myCurrentOrder; // 1 o 2
	private int currentYear; //anno corrente
	private int months[]=new int[5]; //[8|9|10|11|12]
	
	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(timespan==11)
			return Decision.LIQUIDATE_FUND;
		
		
			if(myCurrentOrder==1) {
				if(timespan==9 && currentYear%2!=0 && months[1]>1)
					return (new WackyWizard()).askKeepOrLiquidate(fundValue, timespan);
				}
			else if(myCurrentOrder==2) {
				if(timespan==10 && myCoins <= partnerCoins)
					return Decision.LIQUIDATE_FUND;
				if(timespan==8 && currentYear%2!=0 && myCoins <= partnerCoins && months[0]>1)
					return (new WackyWizard()).askKeepOrLiquidate(fundValue, timespan);
			}
						
		return Decision.KEEP_FUND;
	}
	
	@Override
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		if(year==1) {
			initMonths();
		}
		this.myCoins = yourCoins;
		this.partnerCoins = partnerCoins;
		this.myCurrentOrder = order;
		this.currentYear=year;
	}
	
	@Override
	public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
		if((yourRevenue<partnerRevenue) && time>7)
			months[time-8]++;			
    }
	
	private void initMonths() {
		for(int i=0;i<months.length;i++)
			months[i]=0;
	}

}
