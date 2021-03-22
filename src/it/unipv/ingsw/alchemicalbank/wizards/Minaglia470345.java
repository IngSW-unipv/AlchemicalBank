package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

/**
 * @author Francesco Minaglia 470345
 *
 * Member of the Screaming Hairy Armadillo Team ( ͡° ͜ʖ ͡°)
 */

/*CODE DESCRIPTION:
 *The target of this code is to let win another member of our team,
 *also known as "Master". The aim is to give him the possibility to earn 
 *more money as possible, whenever he is playing against me.
 *Instead, when the other player isn't the Master, I boycott him by 
 *closing the fund as soon as possible.
 */

public class Minaglia470345 extends Wizard {

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        // Let the master wizard win if I'm playing with him
        if (MurerDanieleWizard.masterIsPlaying)
            return Decision.KEEP_FUND;

        // Boycott other wizards otherwise ( ͡° ͜ʖ ͡°)
        return Decision.LIQUIDATE_FUND;
    }

    @Override
    public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
        // Tell the master wizard that I'm no longer playing
        MurerDanieleWizard.aPartnerIsPlaying = false;
    }

    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        // Tell the master wizard that I'm playing
        MurerDanieleWizard.aPartnerIsPlaying = true;
    }

}

