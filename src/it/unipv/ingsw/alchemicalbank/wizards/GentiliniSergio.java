package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

/**
 * Cognome: Gentilini
 * Nome: Segio
 * Numero di matricola: 447294
 */

public class GentiliniSergio extends Wizard {
    private int numeroStrategia = 1;

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if (numeroStrategia == 2) {
            if ((timespan == 8) || (timespan == 9)) return Decision.LIQUIDATE_FUND;
            return Decision.KEEP_FUND;
        }
        if (fundValue >= 30000) {
            if ((timespan == 8) || (timespan == 9)) return Decision.LIQUIDATE_FUND;
            return Decision.KEEP_FUND;
        }
        if ((timespan == 10) || (timespan == 11)) return Decision.LIQUIDATE_FUND;
        return Decision.KEEP_FUND;
    }

    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        if ((year >= 45) && (yourCoins < 30000)) numeroStrategia = 2;
        else numeroStrategia = 1;
    }
}
