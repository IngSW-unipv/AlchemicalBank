package unipv.ingsw.alchemicalbank;


import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.matchprocessor.SubclassMatchProcessor;
import unipv.ingsw.alchemicalbank.wizards.GreedyWizard;
import unipv.ingsw.alchemicalbank.wizards.PatientWizard;
import unipv.ingsw.alchemicalbank.wizards.WackyWizard;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;


/**
 * A branch of the Alchemical Bank.
 */
public final class Bank {
    /// The logger for this class.
    private final static Logger LOGGER = Logger.getLogger(Bank.class.getName());
    /// The list of dealers in the market.
    private final List<Wizard> clients = new ArrayList<>();
    /// Value in a new account.
    private final int INITIAL_ACCOUNT_VALUE = 10;

    /**
     * Populate the list of clients.
     */
    public void summonClients() {
        clients.clear();

        // Add all descendants of the Wizard class
        FastClasspathScanner scanner = new FastClasspathScanner("it.unipv.ingsw");
        scanner.matchSubclassesOf(Wizard.class, new SubclassMatchProcessor<Wizard>() {
            @Override
            public void processMatch(Class<? extends Wizard> w) {
                try {
                    clients.add(w.getDeclaredConstructor().newInstance());
                } catch (Exception e) {
                    LOGGER.log(Level.SEVERE, e.toString(), e);
                }
            }
        }).scan();

        // Verify the initial balance of the dealers.
        for (Wizard w : clients)
            checkBalance(w, 0);

        // Add extra dealers.
        for (int i = 0; i < 10; i++)
            clients.add(new PatientWizard());
        for (int i = 0; i < 9; i++)
            clients.add(new WackyWizard());

        // except 'GreedyWizard' if they are in an odd number.
        if (clients.size() % 2 != 0) {
            clients.add(new GreedyWizard());
        }

        LOGGER.info(clients.size() + " clients summoned");
    }


    /**
     * Prevent wizards from cheating by changing their own balance.
     * <p>
     * Cheaters get a fine.
     *
     * @param client   the wizard
     * @param expected the expected balance
     */
    private void checkBalance(Wizard client, int expected) {
        int balance = client.getCoins();
        if (balance > expected) {
            LOGGER.warning(client.getName() + " is cheating!");
            long new_balance = expected;
            new_balance -= 100 * (balance - expected);
            if (new_balance < Integer.MIN_VALUE)
                new_balance = Integer.MIN_VALUE;
            client.addCoins((int) new_balance - balance);
        }
    }

    public void runSimulation(int years) {
        for (int year = 0; year < years; year++)
            simulateYear();
    }

    private void simulateYear() {
        // Wizards are paired by taking consecutive elements in the list after it has been randomly shuffled.
        Collections.shuffle(clients);
        for (int i = 0; i < clients.size() - 1; i += 2)
            manageAccount(clients.get(i), clients.get(i + 1));
    }

    private void manageAccount(Wizard firstHolder, Wizard secondHolder) {
        firstHolder.addCoins(INITIAL_ACCOUNT_VALUE / 2);
        secondHolder.addCoins((INITIAL_ACCOUNT_VALUE + 1) / 2);
        Account account = new Account(INITIAL_ACCOUNT_VALUE, firstHolder, secondHolder);
        while (!account.isClosed())
            account.advance();
        account.payHolders();
    }

    /**
     * Sort the list of clients by decreasing profit.
     */
    public void sortClients() {
        Collections.sort(clients);
        Collections.reverse(clients);
    }

    /**
     * Return a defensive copy of the list of dealers.
     */
    public List<Wizard> getClients() {
        return Collections.unmodifiableList(clients);
    }
}
