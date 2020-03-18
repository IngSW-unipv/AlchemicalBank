package it.unipv.ingsw.alchemicalbank.wizards;

import java.security.Timestamp;
import java.util.ArrayList;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class AngelicaSeiberl extends Wizard {

	private long partnerCoins;
	private long yourCoins;
	private int order;
	private int countDispari;
	private int countPari;
	private int lastTimePartnerclosed;

//	private ArrayList<Integer> timeClosed;
	public AngelicaSeiberl() {
		super();
		this.countDispari = 0;
		this.countPari = 0;
	}

	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		// TODO Auto-generated method stub
		this.partnerCoins = partnerCoins;
		this.yourCoins = yourCoins;
		this.order = order;
		
	}

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		// TODO Auto-generated method stub

		if ((this.order == 1) && (this.countDispari >= this.countPari)) {
			if (timespan == 11) {

				// if(yourCoins >= partnerCoins) {
				return Decision.LIQUIDATE_FUND;
			} else  {
				return Decision.KEEP_FUND;

			}
			
		} else if ((this.order == 0) && (this.countPari >= this.countDispari)) {

			if (timespan > 11)  {

				return Decision.LIQUIDATE_FUND;
			} else {
				return Decision.KEEP_FUND;

			}
			
		}
		
		if(timespan == this.lastTimePartnerclosed - 1) {
			return Decision.LIQUIDATE_FUND;
			
		}
		return Decision.KEEP_FUND;

	}

	@Override
	public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
		// TODO Auto-generated method stub
//	timeClosed.add(time);
		
		

		if ((time % 2) == 0) {
			
			this.countPari++;
			if(this.order == 1) {
				this.lastTimePartnerclosed = time;
			}
		} else {
			this.countDispari++;
			if(this.order == 2) {
				this.lastTimePartnerclosed = time;
			}
		}
		
		
		

	}

	
}
