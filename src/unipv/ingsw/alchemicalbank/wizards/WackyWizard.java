package unipv.ingsw.alchemicalbank.wizards;

import unipv.ingsw.alchemicalbank.Decision;
import unipv.ingsw.alchemicalbank.Wizard;

import java.util.Random;

/**
 * A wizard that decides randomly.
 */
public class WackyWizard extends Wizard {

    private Random randomGenerator = new Random();

    @Override
    public Decision askKeepOrClose(int accountValue, int timespan, int otherCoins) {
        if (randomGenerator.nextBoolean())
            return Decision.KEEP_ACCOUNT;
        else
            return Decision.CLOSE_ACCOUNT;
    }
}
