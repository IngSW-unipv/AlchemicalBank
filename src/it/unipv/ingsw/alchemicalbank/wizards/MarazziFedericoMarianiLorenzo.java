package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class MarazziFedericoMarianiLorenzo extends Wizard{

    //MARAZZI FEDERICO 448929
    //MARIANI LORENZO 448295

    //maximizing the earnings by closing the fund in the middle of the year
    private final int MAX_MAGO1 = 11, MAX_MAGO2 = 12;

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan){
        if(timespan == MAX_MAGO1 || timespan == MAX_MAGO2){
            return Decision.LIQUIDATE_FUND;
        } else {
            return Decision.KEEP_FUND;
        }
    }
}
