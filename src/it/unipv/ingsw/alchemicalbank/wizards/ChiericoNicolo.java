package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class ChiericoNicolo extends Wizard {

    //Nicolò Chierico 448889

        public Decision askKeepOrLiquidate(int fundValue, int timespan) {

            if(timespan > 10){
                return Decision.LIQUIDATE_FUND;
            }else return Decision.KEEP_FUND;
        }

}
