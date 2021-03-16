package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class CattabrigaWizard extends Wizard {

	private int lastValue = 0;
	private int roofValue= 4096;
	private int timespan=0;
	private int margin;
	private int count=0;
	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		this.margin= roofValue/20;
		this.lastValue=fundValue;
		if (this.timespan <= timespan) {
			count=0;
			if (lastValue>(roofValue-margin)) {
				roofValue=lastValue;
			}else
				roofValue=roofValue-margin;
		}
		
		if (count==1) {
			roofValue=roofValue*2;
		}
		if (fundValue >=roofValue ) {
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
