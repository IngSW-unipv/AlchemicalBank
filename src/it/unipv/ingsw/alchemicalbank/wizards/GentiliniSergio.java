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
        return Decision.KEEP_FUND;
    }
}
