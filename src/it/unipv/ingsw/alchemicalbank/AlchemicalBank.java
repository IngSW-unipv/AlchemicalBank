package it.unipv.ingsw.alchemicalbank;


import java.util.List;

public class AlchemicalBank {

    private static final int DEFAULT_YEARS = 10;


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
        bank.sortClients();
        System.out.println("FINAL RANKING");
        printRanking(bank.getClients());
    }

    /**
     * Print the final ranking to stdout.
     */
    private static void printRanking(List<Wizard> clients) {
        int rank = 0;
        for (Wizard w : clients)
            System.out.printf("%3d) %21s %+6d\n", ++rank, w.getName(), w.getCoins());
    }
}
