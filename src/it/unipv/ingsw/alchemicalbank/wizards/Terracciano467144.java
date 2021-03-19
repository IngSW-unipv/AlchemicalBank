package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

//Studente: Alessandro Terracciano
//Mat. n° 467144

public class Terracciano467144 extends Wizard {
	
	private int year;
	private int order;
	private long myCoins;
	private long theirCoins;
	private boolean win=false;
	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		// TODO Auto-generated method stub
		if(year==1)
		{
			if(timespan>10)
			{
				return Decision.LIQUIDATE_FUND;
			}
			else
			{
				return Decision.KEEP_FUND;
			}
		}
		else if(year>=2 && year<=99)
		{
			if(win)
			{
				return Decision.KEEP_FUND;
			}
			else
			{
				if(timespan>7 || this.theirCoins>2*this.myCoins)
				{
					return Decision.LIQUIDATE_FUND;
				}
				else
				{
					return Decision.KEEP_FUND;
				}
			}
		}
		else
		{
			double fear=Math.random();
			if(fear>0.7)
			{
				if(timespan>7)
				{
					return Decision.LIQUIDATE_FUND;
				}
				else
				{
					return Decision.KEEP_FUND;
				}
			}
			else
			{
				if(timespan>10 || (timespan>7 && this.theirCoins>2*this.myCoins))
				{
					return Decision.LIQUIDATE_FUND;
				}
				else
				{
					return Decision.KEEP_FUND;
				}
			}
		}
	}
	
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        this.year=year;
        this.order=order;
        this.myCoins=yourCoins;
        this.theirCoins=partnerCoins;
    }
	
	public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
        if(yourRevenue>partnerRevenue)
        {
        	win=true;
        }
        else
        {
        	win=false;
        }
    }
}
