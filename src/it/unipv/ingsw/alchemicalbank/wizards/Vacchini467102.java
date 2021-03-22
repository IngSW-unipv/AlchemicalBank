package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.*;

/**
 * @author Edoardo Vacchini 467102
 * Member of the Screaming Hairy Armadillo Gang ( ͡° ͜ʖ ͡°)
 * 
 * The code below is the result of a strategy based on a team strategy. The objective is to divert 
 * all the revenue towards one of us (MurerDanieleWizard), while sabotaging the other players. If
 * matched with DanieleMurerWizard, Vacchini467102 will make sure to give the maximum amount of 
 * coins to him. If matched with any other player, Vacchini467102 will liquidate the fund as soon
 * as possible resulting in the opponent getting the smallest amount of coins possible.
 * 
 * "So long, and thanks for all the fish"
 * 
 */

public class Vacchini467102 extends Wizard {

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
