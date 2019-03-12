package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;
import java.util.Random;


public class CottaRamusinoAdriano extends Wizard {
    //Adriano Cotta Ramusino 446248

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        Random rand = new Random();
        int n = rand.nextInt(100)+1;


      if (timespan%2==0) {
            if (timespan>8 && fundValue>=5000)
                return Decision.LIQUIDATE_FUND;
            else
                return Decision.KEEP_FUND;
        }
        else {
            if (timespan>9 && fundValue>=5000)
                return Decision.LIQUIDATE_FUND;
            else
                return Decision.KEEP_FUND;
        }
    }
}
