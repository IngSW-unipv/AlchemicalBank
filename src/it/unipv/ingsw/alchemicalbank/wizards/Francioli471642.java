package it.unipv.ingsw.alchemicalbank.wizards;

import java.util.*;
import java.lang.*;

// @author Francioli Lucia 471642
import it.unipv.ingsw.alchemicalbank.*;

public class Francioli471642 extends Wizard {
	private int sum,move,index,actualYear;
	private ArrayList<Integer> close=new ArrayList<Integer>();
	
	
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		this.actualYear = year;
	}
	
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		if(actualYear<60) {
			if(timespan>=10)
			return Decision.LIQUIDATE_FUND;
		else
			return Decision.KEEP_FUND;
		}else {
			for(Integer x: close) {
				sum+=(int)x;
		}
		move=(sum/close.size());
		move-=1;
		if(timespan==move)
			return Decision.LIQUIDATE_FUND;
		 else 
			
			return Decision.KEEP_FUND;
						
	}
	}
	
	
	public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
		close.add((Integer)time);
		
	}
	
	

}
