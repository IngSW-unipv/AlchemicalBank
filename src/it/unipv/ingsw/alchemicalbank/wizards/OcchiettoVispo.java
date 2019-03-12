package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class OcchiettoVispo extends Wizard {

    //Nicolò Chierico 448889, Adriano Cotta Ramusino 446248

        public Decision askKeepOrLiquidate(int fundValue, int timespan) {

            if(timespan > 10){
                return Decision.LIQUIDATE_FUND;
            }else return Decision.KEEP_FUND;
        }

}
