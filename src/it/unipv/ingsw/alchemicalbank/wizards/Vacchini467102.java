package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.*;

//Edoardo Vacchini (Matricola 467102)

public class Vacchini467102 extends Wizard{
	private long myCoins, hisCoins;
	private int order, time, myRevenue, hisRevenue, year;
	
	@Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {		
		if(timespan == 10 && timespan == 11) // soluzione a breve termine con il miglior guadagno supponendo di essere arrivati in fondo e quindi di avere contro uno che aspetta
			return Decision.LIQUIDATE_FUND;
		else if(10*Math.pow(2, this.time)/this.year >= (this.hisCoins + 10*Math.pow(2, this.time))/this.year) // cerco di intuire dalla media dei guadagni qual � il go-to round per ritirare
			return Decision.LIQUIDATE_FUND;
		else
			return Decision.KEEP_FUND;
    }
	
	@Override
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		this.myCoins = yourCoins;
		this.hisCoins = partnerCoins;
		this.order = order;
		this.year = year;
    }
	
	@Override
	public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
        this.myRevenue = yourRevenue;
        this.hisRevenue = partnerRevenue;
        this.time = time;
    }
}
