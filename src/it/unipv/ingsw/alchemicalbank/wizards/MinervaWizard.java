package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

import java.util.Random;

public class MinervaWizard extends Wizard {

    private Random randomGen = new Random();
    private long partnerCoins = 0;
    private int year;

    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        this.partnerCoins = partnerCoins;
        this.year = year;
    }

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {

        if(timespan==8||timespan==9) return Decision.LIQUIDATE_FUND;
        else return Decision.KEEP_FUND;

    }


}
