package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;


// FECCHIO ANDREA   447237

public class FecchioAndrea extends Wizard {
    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if( timespan==10 || timespan==11){
            return Decision.LIQUIDATE_FUND;
        }
        else{
            return  Decision.KEEP_FUND;
        }
    }
}
