package it.unipv.ingsw.alchemicalbank.wizards;

// Riccardo 449564
import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class GodracciR extends Wizard {

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {

        if (fundValue>18000) {return Decision.LIQUIDATE_FUND; }
        else
            return Decision.KEEP_FUND;

    }
}
