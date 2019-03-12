package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

//Zippo Manuel 446424

public class AzzimoWizard extends Wizard {

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if (timespan % 2 == 0) {
            if (timespan > 9)
                return Decision.LIQUIDATE_FUND;
            else
                return Decision.KEEP_FUND;
        }
        else {
            if (timespan > 10)
                return Decision.LIQUIDATE_FUND;
            else
                return Decision.KEEP_FUND;
        }
    }
}
