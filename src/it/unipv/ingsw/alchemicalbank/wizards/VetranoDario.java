package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class VetranoDario extends Wizard {

    private boolean vantage;

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
            if (vantage) {
                if (timespan < 8) {
                    return Decision.KEEP_FUND;
                } else return Decision.LIQUIDATE_FUND;
            } else if (timespan < 6) {
                return Decision.KEEP_FUND;
            } else return Decision.LIQUIDATE_FUND;
        }

    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        if (partnerCoins >= yourCoins){
            vantage = false;
        }
    }
}

//Nome: Dario Giacomo Vetrano
// Matricola: 436575