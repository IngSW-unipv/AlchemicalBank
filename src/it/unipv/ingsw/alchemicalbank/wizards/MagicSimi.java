package it.unipv.ingsw.alchemicalbank.wizards;

//Mago di Ghiazzi Simone Matricola: 446597

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class MagicSimi extends Wizard {
    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if(fundValue%timespan==0 && timespan<10){
            return Decision.KEEP_FUND;
        }
        if (timespan==7){
        return Decision.LIQUIDATE_FUND;
        }
        return Decision.KEEP_FUND;
    }
}
