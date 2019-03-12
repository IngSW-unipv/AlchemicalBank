package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

import java.util.Random;

public class LinoBanfiWizard extends Wizard {

//Andrea Curtoni 446018

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {

            if (fundValue < 10240)
                return Decision.KEEP_FUND;
            else
                return Decision.LIQUIDATE_FUND;
        }
    }
