package unipv.ingsw.alchemicalbank;


import java.util.List;

public class AlchemicalBank {

    public static void main(String[] args) {
        // Setup and run the simulation.
        Bank bank = new Bank();
        bank.summonClients();
        bank.runSimulation(20);

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
