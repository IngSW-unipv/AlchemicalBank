package it.unipv.ingsw.alchemicalbank;


import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.matchprocessor.SubclassMatchProcessor;
import it.unipv.ingsw.alchemicalbank.wizards.WackyWizard;

import java.util.*;
import java.util.logging.Logger;
import java.util.logging.Level;


/**
 * A branch of the Alchemical Bank.
 */
public final class Bank {
    /// The logger for this class.
    private final static Logger LOGGER = Logger.getLogger(Bank.class.getName());

    /// The list of clients of the bank
    private final Map<Wizard, Long> accounts = new HashMap<>();

    /// Value in a new account
    private final int FUND_STARTING_VALUE = 10;

    /// Coins owned by new clients
    private final long STARTING_BALANCE = 100;

    /**
     * Populate the list of clients.
     */
    public void summonClients() {
        accounts.clear();

        // Add one instance of all descendants of the Wizard class
        FastClasspathScanner scanner = new FastClasspathScanner("it.unipv.ingsw");
        scanner.matchSubclassesOf(Wizard.class, new SubclassMatchProcessor<Wizard>() {
            @Override
            public void processMatch(Class<? extends Wizard> w) {
                try {
                    Wizard new_client = w.getDeclaredConstructor().newInstance();
                    accounts.put(new_client, STARTING_BALANCE);
                } catch (Exception e) {
                    LOGGER.log(Level.SEVERE, e.toString(), e);
                }
            }
        }).scan();

        // Add one extra 'WackyWizard' if they are in an odd number
        if (accounts.size() % 2 != 0)
            accounts.put(new WackyWizard(), STARTING_BALANCE);

        LOGGER.info(accounts.size() + " clients summoned");
    }

    /**
     * Perform the given years of simulation.
     *
     * @param years
     */
    public void runSimulation(int years) {
        for (int year = 1; year <= years; year++) {
            LOGGER.info(String.format("Year %d of %d", year, years));
            simulateYear(year);
        }
    }

    /**
     * Run one simulated year.
     */
    private void simulateYear(int year) {
        // Wizards are paired by taking consecutive elements in a list after it has been randomly shuffled
        List<Wizard> clients = new ArrayList<>(accounts.keySet());
        Collections.shuffle(clients);
        for (int i = 0; i < clients.size() - 1; i += 2)
            manageFund(year, clients.get(i), clients.get(i + 1));
    }

    /// Create a new fund for the pair of wizards and manage it until it gets closed
    private void manageFund(int year, Wizard firstOwner, Wizard secondOwner) {
        long coins1 = accounts.get(firstOwner).longValue();
        long coins2 = accounts.get(secondOwner).longValue();
        firstOwner.newFund(year, 1, coins1, coins2);
        secondOwner.newFund(year, 2, coins2, coins1);
        InvestmentFund fund = new InvestmentFund(FUND_STARTING_VALUE, firstOwner, secondOwner);
        while (!fund.isClosed())
            fund.nextMonth();
        int[] revenues = fund.computeRevenues();
        firstOwner.fundClosed(fund.getTime(), revenues[0], revenues[1]);
        accounts.put(firstOwner, coins1 + (long)revenues[0]);
        accounts.put(secondOwner, coins2 + (long)revenues[1]);
        String msg = String.format("%16s closes the fund after %2d months: %-16s (%+6d) / %-16s (%+6d)",
                fund.getLiquidator().getName(), fund.getTime(),
                firstOwner.getName(), revenues[0],
                secondOwner.getName(), revenues[1]);
        LOGGER.info(msg);
    }

    /**
     * Sort the list of clients by decreasing profit.
     */
    public List<Map.Entry<Wizard, Long>> sortedClients() {
        List<Map.Entry<Wizard, Long>> clients = new ArrayList<>(accounts.entrySet());
        Collections.sort(clients, new Comparator<Map.Entry<Wizard, Long>>() {
            @Override
            public int compare(Map.Entry<Wizard, Long> e1, Map.Entry<Wizard, Long> e2) {
                return Long.compare(e2.getValue(), e1.getValue());
            }
        });
        return clients;
    }
}
