package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Wizard;
import it.unipv.ingsw.alchemicalbank.Decision;

//Andrea Stella 447213
//Roberto Zappa 450488
public class STELLAZAPPA extends Wizard {

    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
            if(timespan == 10 || timespan == 11){
                return  Decision.LIQUIDATE_FUND;
            }  else return Decision.KEEP_FUND;
        }

}
