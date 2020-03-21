package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

//Beatrice Burzo 446336

public class BeatriceBurzo extends Wizard {

    private int order;
    private int year;

    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        // TODO Auto-generated method stub
        super.newFund(year, order, yourCoins, partnerCoins);

        this.order = order;
        this.year = year;
    }
	
    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan){
    	
        if(order == 2 && fundValue > 17000)
            return Decision.LIQUIDATE_FUND;
        if(order == 1 && fundValue > 15000)
            return Decision.LIQUIDATE_FUND;
        
        else
            return Decision.KEEP_FUND;
        
    }

}
