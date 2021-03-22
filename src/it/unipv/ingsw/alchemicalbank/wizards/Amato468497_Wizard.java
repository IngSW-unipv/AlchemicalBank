/**
 * @author: Francesco Amato 468497
 *
 * Member of the Screaming Hairy Armadillo TEAM ( ͡° ͜ʖ ͡°)
 */


/* CODE DESCRIPTION : 
 * The target of this code is to let win one member of our Team
 * (Daniele Murer Wizard, more specifically), also known as the "Master".
 * The aim is to "giving" him the possibility to earn 
 * more money as possible, whenever he is playing against me.
 * (I never close the fund, the Master closes the fund at the 11 month). 
 * Instead, when the other player isn't Daniele, I boycott him 
 * (closing as soon as possible the fund).
 * 
 * The "boycotting part" is the real strength key of this code 
 * (due to probability).
 */


package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.*;

//MY WIZARD CLASS
public class Amato468497_Wizard extends Wizard {

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        // Let the master wizard win if I'm playing "against" him
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