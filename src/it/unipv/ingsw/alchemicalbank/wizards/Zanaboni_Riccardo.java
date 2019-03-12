package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;


// ZANABONI RICCARDO 445667

public class Zanaboni_Riccardo extends Wizard {
    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if(timespan%2==0 && timespan>9){
            return Decision.LIQUIDATE_FUND;
        }
        if(timespan%2!=0 && timespan>8){
            return Decision.LIQUIDATE_FUND;
        }
        else{
            return  Decision.KEEP_FUND;
        }
    }
}
