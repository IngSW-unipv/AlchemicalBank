package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

import java.util.Random;

public class MinervaWizard extends Wizard {
    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {

        if(timespan==11||timespan==10) return Decision.LIQUIDATE_FUND;
        else return Decision.KEEP_FUND;
        //test prova

    }


}