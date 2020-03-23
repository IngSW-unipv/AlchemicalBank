package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;


public class MinervaWizard extends Wizard {

    //Simone Antonio Minerva 444563

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {

        if(timespan==11||timespan==12) return Decision.LIQUIDATE_FUND;
        else return Decision.KEEP_FUND;


    }


}
