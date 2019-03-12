package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class ChiericoNicolo extends Wizard {

    //Nicolò Chierico 448889

        public Decision askKeepOrLiquidate(int fundValue, int timespan) {
            if (timespan%2==0) {
                if (timespan>8)
                    return Decision.LIQUIDATE_FUND;
                else
                    return Decision.KEEP_FUND;
            }
            else {
                if (timespan>9)
                    return Decision.LIQUIDATE_FUND;
                else
                    return Decision.KEEP_FUND;
            }
        }
}


