package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;



public class GremiPaolo extends Wizard {
    public int yearOfSimulation;
    public int order;
    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if (timespan < 10) {//da modificare l'if condition
            return Decision.KEEP_FUND;
        }
        else{
            return Decision.LIQUIDATE_FUND;
        }
    }


}
