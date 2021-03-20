package it.unipv.ingsw.alchemicalbank.wizards;

import java.util.*;

// @author Francioli Lucia 471642
import it.unipv.ingsw.alchemicalbank.*;

public class Francioli471642 extends Wizard {
	private ArrayList<Integer> close=new ArrayList<Integer>();
	private int sum,move;
	
	
	
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		for(Integer x: close) {
			sum+=x;
		}
		move=(sum/close.size())-1;
		if(timespan==move)
			return Decision.LIQUIDATE_FUND;
		 else 
			
			return Decision.KEEP_FUND;
						
	}
	
	public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
		close.add(time);
	}
	
	

}
