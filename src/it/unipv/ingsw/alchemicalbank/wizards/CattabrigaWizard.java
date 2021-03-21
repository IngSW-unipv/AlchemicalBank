package it.unipv.ingsw.alchemicalbank.wizards;

import java.lang.Math;
import it.unipv.ingsw.alchemicalbank.Decision;

import it.unipv.ingsw.alchemicalbank.Wizard;

public class CattabrigaWizard extends Wizard {

	private int roofValue= 16384;
	private int timespan=0;
	private int count=0;
	private int countfail=0;
	
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		
		if (this.timespan > timespan) {
			countfail++;
			if (countfail==3) {
				count=0;
			countfail=0;
			this.timespan=0;
			roofValue=roofValue/4;
			}
		}
		
		if (count==1) {
			if (roofValue< 16384) {
			roofValue=roofValue*4;
			count=0;
			countfail=0;
			}
			else
			{	
				roofValue=16384;
				countfail=0;
				count=0;
			}
		}
		
		if(roofValue < 4096) {if (Math.random()<0.70) {roofValue=4096;return  Decision.LIQUIDATE_FUND;}else return Decision.KEEP_FUND;}
		
		if (fundValue >=roofValue || timespan>=11 ) {
			this.timespan=0;
			this.count++;
			return Decision.LIQUIDATE_FUND;
		}else
			{
				this.timespan=timespan;
				return Decision.KEEP_FUND;
			}
	}

}
