package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;


// ZANABONI RICCARDO 445667

public class Zanaboni_Riccardo extends Wizard {
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
