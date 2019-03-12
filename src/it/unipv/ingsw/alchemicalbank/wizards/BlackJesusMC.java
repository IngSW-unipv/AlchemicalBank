package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class BlackJesusMC extends Wizard {


    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {

        if (timespan % 2==0) {
            //Wizard1
        }else{
            //Wizard2
        }



        return null;
    }
}
