package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class BlackJesusMC extends Wizard {


    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {

        if (timespan % 2 == 0) { //Wizard 2
            return Decision.KEEP_FUND;
        }else{//Wizard 1
            return Decision.LIQUIDATE_FUND;
        }

    }
}
