package it.unipv.ingsw.alchemicalbank;


import java.util.List;
import java.util.Map;


/**
 * Class that setup and execute the simulation.
 */
public class AlchemicalBank {

    private static final int DEFAULT_YEARS = 1000;

    /**
     * Main method
     *
     * @param args optionally specify the number of years of simulation
     */
    public static void main(String[] args) {
        // Print one line per log event to make it easier to read.
        // System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT %4$s %2$s %5$s%6$s%n");
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT %4$s %5$s%6$s%n");

        // Setup and run the simulation.
        int years = (args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_YEARS);
        Bank bank = new Bank();
        bank.summonClients();
        bank.runSimulation(years);

        // Sort the dealers and print their scores.
        List<Map.Entry<Wizard, Long>> clients = bank.sortedClients();
        System.out.println("FINAL RANKING");
        printRanking(clients);
    }

    /**
     * Print the final ranking to stdout.
     * @param wizards list of wizards with their coins
     */
    private static void printRanking(List<Map.Entry<Wizard, Long>> wizards) {
        int rank = 0;
        for (Map.Entry<Wizard, Long> e : wizards)
            System.out.printf("%3d) %21s %+6d\n", ++rank, e.getKey().getName(), e.getValue().longValue());
    }
}
