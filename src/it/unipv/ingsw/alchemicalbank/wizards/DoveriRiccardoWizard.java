package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class DoveriRiccardoWizard extends Wizard {
    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        switch (fundValue) {
            case 20:
                return Decision.KEEP_FUND;
            case 40:
                return Decision.KEEP_FUND;
            case 80:
                return Decision.KEEP_FUND;
            case 160:
                return Decision.KEEP_FUND;
            case 320:
                return Decision.LIQUIDATE_FUND;
            case 640:
                return Decision.LIQUIDATE_FUND;
            case 1280:
                return Decision.KEEP_FUND;
            case 2560:
                return Decision.KEEP_FUND;
            case 5120:
                return Decision.KEEP_FUND;
            case 10240:
                return Decision.KEEP_FUND;
            case 20480:
                return Decision.KEEP_FUND;
            case 40960:
                return Decision.KEEP_FUND;
                default:
                    return Decision.LIQUIDATE_FUND;
        }
    }
}
