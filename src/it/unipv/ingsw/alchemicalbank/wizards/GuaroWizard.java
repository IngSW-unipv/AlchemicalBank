package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;


/**
 * Cognome: Guareschi
 * Nome: Federico
 * Matricola: 445648
 */
public class GuaroWizard extends Wizard {

    public Decision askKeepOrLiquidate(int fundValue, int timespan){
            if (timespan>9)
                return Decision.LIQUIDATE_FUND;
            else
                return Decision.KEEP_FUND;
    }

    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        super.newFund(year, order, yourCoins, partnerCoins);
    }

    @Override
    public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
        super.fundClosed(time, yourRevenue, partnerRevenue);
    }
}
