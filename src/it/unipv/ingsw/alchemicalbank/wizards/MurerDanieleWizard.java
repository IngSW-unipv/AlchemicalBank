package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.*;

/**
 * @author Daniele Murer 466558
 */

public final class MurerDanieleWizard extends Wizard {

    public static boolean masterIsPlaying = false;

    public static boolean aPartnerIsPlaying = false;

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        return (timespan >= 11) ? Decision.LIQUIDATE_FUND : Decision.KEEP_FUND;
    }

}
