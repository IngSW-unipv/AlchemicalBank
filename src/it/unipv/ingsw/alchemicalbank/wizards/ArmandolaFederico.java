package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

import java.util.Random;

/*

* Armandola Federico 447587
* Belcore Daniel 447520

 */

public class ArmandolaFederico extends Wizard {

    private int valore;
    private int ordine;

    private Random randomGenerator = new Random();
    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan)
    {

        if(ordine == 1 &&  timespan==11  && fundValue>valore)
        {

            return Decision.LIQUIDATE_FUND;

        }
        else if(ordine == 2 && timespan == 10  && fundValue>valore )
            {
                return Decision.LIQUIDATE_FUND;
            }
            else {
            return  Decision.KEEP_FUND;
        }

    }


    @Override
    public void fundClosed(int time, int yourRevenue, int partnerRevenue)
    {
        super.fundClosed(time, yourRevenue, partnerRevenue);

        this.valore = partnerRevenue;

    }

    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        super.newFund(year, order, yourCoins, partnerCoins);
        this.ordine=order;
    }
}
