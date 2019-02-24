package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class PatientWizard extends Wizard {
    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan, int otherCoins) {
        return Decision.KEEP_FUND;
    }
}
