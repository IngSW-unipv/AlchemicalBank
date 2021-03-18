package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

/**
 * A wizard that wants to win.
 */
public class Scardovi470583Wizard extends Wizard {
	
	private int end;
	private int year;
	private int order;
	private long myCoins;
	private long partnerCoins;
	private int time;
	private int myRevenue;
	private int partnerRevenue;
	
	public Scardovi470583Wizard() {
		this.end = 8;
		this.year = 0;
		this.order = 1;
		this.myCoins = 0;
		this.partnerCoins = 0;
		this.time = 0;
		this.myRevenue = 0;
		this.partnerRevenue = 0;
	}
	
	@Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
    	Decision d = Decision.KEEP_FUND;

		if (timespan > end) {
			d = Decision.LIQUIDATE_FUND;
		}
		return d;
    }
    
    /**
     * Called when a new fund get opened.  By default does nothing, but subclasses may override it if they want to use
     * this information to adjust their strategy.
     *
     * @param year         Year of simulation (starting from 1)
     * @param order        whether is  the first (1) or second (2) to take decisions
     * @param yourCoins amount of coins owned by the wizard before the new fund is opened
     * @param partnerCoins amount of coins owned by the partner
     */
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
    	this.year = year;
    	this.order = order;
    	this.myCoins = yourCoins;
    	this.partnerCoins = partnerCoins;
    }

    /**
     * Called when a fund gets liquidated.  By default does nothing, but subclasses may override it if they want to use
     * this information to adjust their strategy.
     *
     * @param time months since the fund was opened
     * @param yourRevenue the revenue due to the wizard
     * @param partnerRevenue the revenue due to the partner
     */
    public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
        this.time = time;
        this.myRevenue = yourRevenue;
        this.partnerRevenue = partnerRevenue;
    }
    
}
