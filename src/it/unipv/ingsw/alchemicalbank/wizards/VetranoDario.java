package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class VetranoDario extends Wizard {
    
    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if (timespan < 6){
            return Decision.KEEP_FUND;
        }
        else return Decision.LIQUIDATE_FUND;
    }
}

//Nome: Dario Giacomo Vetrano
// Matricola: 436575