package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

/**
 * Cognome: Gentilini
 * Nome: Segio
 * Numero di matricola: 447294
 */

public class GentiliniSergio extends Wizard {
    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if (fundValue >= 30000) {
            if ((timespan == 8) || (timespan == 9)) return Decision.LIQUIDATE_FUND;
            return Decision.KEEP_FUND;
        }
        if ((timespan == 10) || (timespan == 11)) return Decision.LIQUIDATE_FUND;
        return Decision.KEEP_FUND;
    }


}
