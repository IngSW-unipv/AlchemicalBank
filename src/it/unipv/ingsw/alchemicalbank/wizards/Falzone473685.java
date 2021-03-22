package it.unipv.ingsw.alchemicalbank.wizards;
import java.util.Random;
import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;
/**
 * 
 * @author Paolo Falzone, 473685
 *
 */
public class Falzone473685 extends Wizard {
	private Random randomGenerator = new Random();
	private long myCoins; //tutte le mie monete 
	private long partnerCoins; //le monete del partner
	private int myCurrentOrder; // 1 o 2
	private int currentYear; //anno corrente
	private int months[]=new int[5]; //[8|9|10|11|12]
	
	public Falzone473685() {
		initMonths();
	}
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(timespan==11)
			return Decision.LIQUIDATE_FUND;
		
		
			if(myCurrentOrder==1) {
				if(timespan==9 && currentYear%2!=0 && months[1]>2)
					return getWackyDecision();
				}
			else if(myCurrentOrder==2) {
				if(timespan==10 && myCoins <= partnerCoins)
					return Decision.LIQUIDATE_FUND;
				if(timespan==8 && currentYear%2==0 && myCoins <= partnerCoins && months[0]>4)
					return getWackyDecision();
			}
								
		return Decision.KEEP_FUND;
	}
	
	@Override
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
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
	private Decision getWackyDecision() {
        if (randomGenerator.nextBoolean())
            return Decision.KEEP_FUND;
        else
            return Decision.LIQUIDATE_FUND;
    }

}
