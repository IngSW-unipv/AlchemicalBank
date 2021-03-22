package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.*;

/**
 * @author Lorenzo Paladini 471085
 *
 * Member of the Screaming Hairy Armadillo TEAM 
 */

/* CODE DESCRIPTION :
 * The target of this code is to let win one member of our Team
 * (Daniele Murer Wizard more specifically), also know as the "Master".
 * The aim is to give him the possibility to earn more money as possible,
 * whenever he is playing against me (I never close the fund, the Master closes the fund at the 11 month).
 * Instead, when the other player ins't Daniele, I boycott him
 * (closing as soon as possible the fund).
 */
public class PartnerWizardClassName extends Wizard {

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        // Let the master wizard win if I'm playing with him
        if (MurerDanieleWizard.masterIsPlaying)
            return Decision.KEEP_FUND;

        // Boycott other wizards otherwise 
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
