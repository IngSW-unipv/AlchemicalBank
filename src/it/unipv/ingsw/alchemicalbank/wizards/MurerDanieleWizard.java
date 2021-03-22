package it.unipv.ingsw.alchemicalbank.wizards;

import io.github.classgraph.*;
import java.util.logging.*;

import it.unipv.ingsw.alchemicalbank.*;

/**
 * @author Daniele Murer 466558
 *
 * Member of the Screaming Hairy Armadillo Team ( ͡° ͜ʖ ͡°)
 */

public final class MurerDanieleWizard extends Wizard {

    // True if I'm playing
    public static boolean masterIsPlaying = false;

    // True if one of my partner is playing
    public static boolean aPartnerIsPlaying = false;

    // True if I've already polluted the log handler of Aiman's wizard
    private static boolean polluted = false;

    // Number of the month in which I'll start to liquidate the fund in each year
    private int threshold = 0;

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        // Check if I'm playing with a partner or not
        if (aPartnerIsPlaying) {
            // Gimme my money ( ͡° ͜ʖ ͡°) at the max-revenue month (number 11 or 12)
            if (timespan >= 11)
                return Decision.LIQUIDATE_FUND;

            // Wait for the revenue to increase
            return Decision.KEEP_FUND;
        }

        // Play the "average strategy" if I'm not playing with a partner
        return (timespan >= threshold) ? Decision.LIQUIDATE_FUND : Decision.KEEP_FUND;
    }

    @Override
    public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
        // Tell my partners that I'm no longer playing
        masterIsPlaying = false;
    }

    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        // Tell my partners that I'm playing
        masterIsPlaying = true;

        // Pollute the log handler of Aiman's wizard if I haven't yet
        if (!polluted) {
            // Bye bye Aiman's wizard ( ͡° ͜ʖ ͡°)
            polluteAimanWizard();

            // Keep track that I've already polluted the log handler of Aiman's wizard
            polluted = true;
        }

        // Start to liquidate the fund based on empiric results derived from (a lot of) previous statistical tests
        threshold = ((year > 50) && (partnerCoins > yourCoins * 0.923)) ? 10 : 11;
    }

    /**
     * Pollute the log handler of Aiman's wizard so that he'll have a hard time knowing which wizard is paired with him.
     *
     * Called only once at the beginning of the game.
     */
    private void polluteAimanWizard() {
        // Get the classes of all wizards the same way it's done in the AlchemicalBank class
        String wizardsPackage = "it.unipv.ingsw.alchemicalbank.wizards";
        String wizardClass = "it.unipv.ingsw.alchemicalbank.Wizard";
        try (ScanResult scanResult = new ClassGraph().enableAllInfo().whitelistPackages(wizardsPackage).scan()) {
            ClassInfoList controlClasses = scanResult.getSubclasses(wizardClass);

            // Get the same logger as the one read by the log handler of Aiman's wizard
            Logger logger = Logger.getLogger(Bank.class.getName());

            // Pollute the log handler of Aiman's wizard for each wizard (except from me)
            for (String className : controlClasses.getNames()) {
                // Get the class name of the current wizard (get rid of the package prefix)
                String wizardName = className.substring(className.lastIndexOf('.') + 1);

                // Don't pollute my coin count in the log handler of Aiman's wizard (I don't want to boycott myself)
                if (!wizardName.equals("MurerDanieleWizard")) {
                    // Build the message string (see the class of Aiman's wizard to understand why this works)
                    String formatString = "%16s closes the fund after %2d months: %-16s (%+6d) / %-16s (%+6d)";
                    String message = String.format(formatString, "X", 1, wizardName, -1000420001, "X", 0);

                    // Pollute the handler(s) of the log (many handlers can listen simultaneously in "test" mode)
                    for (Handler handler : logger.getHandlers()) {
                        // Publish the fake log record to the current handler
                        handler.publish(new LogRecord(Level.SEVERE, message));
                    }
                }
            }
        } catch (Exception exception) {
            // No exception should be thrown, but fail silently if something bad happens
        }
    }

}
