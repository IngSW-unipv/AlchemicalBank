package it.unipv.ingsw.alchemicalbank.wizards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import io.github.classgraph.ClassGraph;

import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;
import it.unipv.ingsw.alchemicalbank.AlchemicalBank;
import it.unipv.ingsw.alchemicalbank.Bank;
import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

/*
 * @author Aiman_Al_Masoud 472462
 */


//The idea is to keep track of each participant's capital through the logs.
//Since the partner-pairing process is randomized, there is a very low chance 
//of two wizards having the same exact capital at any given time (except at the very beginning).
//Since the the startNewFund() method tells me exactly how much my partner has, I can quite
//reliably tell what Wizard I'm facing at any round. 

//I can't gain access to the actual Wizard Objects in the Bank, but I can make my own 
//instances of each. Those instances get fed as much info as possible, to determine what
//the actual ones that are playing would do at any turn.

//My goal is to keep the fund open as long as possible, liquidating it 
//as soon as my instance of the opponent's class tells me they'd do it on their next turn.

//Problems with this approach:
//1) Some Wizards rely on randomness to take a Decision, it's quite impossible to 
//know what the seed of the actual object that is playing is.
//2) There's still an element of chance related to the Wizards you get to play against in a game.
//if you only get to face "greedy opponents", even liquidating at the optimum spot all the time 
//isn't gonna make you earn a lot of money. This gets particularly bad for a low number
//of iterations.

public class AimanAlMasoud472462 extends Wizard {

	
	//my current opponent (gets set in the newFund() method)
	private Wizard currentOpponent;
	
	//transactions' logger: exploiting logs to get cumulative info on 
	//opponents' current wealth
	private Logger transactionsLogger = Logger.getLogger(Bank.class.getName());
	
	//latest transaction 
	private String lastTransactionMessage;
	
	//list of wizards and their capitals, there's an instance for each wizard
	//except for this class. 
	private HashMap<Wizard, Long> wizardsAndCapitals = getAllWizards();
	
	
	//wizards that managed to close before me:
	private static ArrayList<Wizard> cunningWizards =  new ArrayList<Wizard>();
	
	final private Handler handler;
	
	public AimanAlMasoud472462() {
	
		
		//add a Handler to the Logger, so as to fetch cumulative info
		//on all of the Wizards' capitals.
		
			    handler= new Handler() {
				@Override
				public void close() throws SecurityException {
				}
				@Override
				public void flush() {	
				}
				@Override
				public void publish(LogRecord arg0) {
					
					
					//prevent any wizard from polluting my logs
					if(wizardsInStack()) {
						return;
					}
					
					
					//get log message
					lastTransactionMessage = arg0.getMessage();	
					
					
					//update capitals of two opponents
					try {
						int startIndex = lastTransactionMessage.indexOf(" months: ")+" months: ".length();
						String wizardsUpdateInfo = lastTransactionMessage.substring(startIndex);
						String[] twoParts = wizardsUpdateInfo.split("/ ");
						
						
						//this is the pattern in each of the twoParts 
						//NameOfWizard\\whitespace(ProfitOfWizard)
						Pattern pattern = Pattern.compile("(.*?)\\s\\((.*?)\\)");
					
						//wizard 1 => parts[0]
						Matcher matcher = pattern.matcher(twoParts[0]);
						matcher.find();
						String wizardOneName = matcher.group(1).trim();
						long wizardOneProfit = Long.parseLong((matcher.group(2).trim()));
					
						//wizard 2 => parts[1]
						matcher = pattern.matcher(twoParts[1]);
						matcher.find();
						String wizardTwoName = matcher.group(1).trim();
						long wizardTwoProfit = Long.parseLong((matcher.group(2).trim()));
						
						//update wizards
						updateWizardsCapital(wizardOneName, wizardOneProfit);
						updateWizardsCapital(wizardTwoName, wizardTwoProfit);
						
					}catch(StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException | IllegalStateException e) {	
					}
				}
				
			};
			
		try {
		transactionsLogger.addHandler(handler);
			
		} catch (SecurityException e) {
			e.printStackTrace();
		} 
		
		
		
		
		
	}
	
	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		
		//if the caller is a wizard, tell them I'm keeping the fund
		if(wizardsInStack()) {
			return Decision.KEEP_FUND;
		}
		
		
		//else if the bank asks me...
		try {
			
			if(currentOpponent.getName().contains("Aiman")&&timespan>=9) {
				return Decision.LIQUIDATE_FUND;
			}
			
			//find out weather they'd liquidate on their next turn:
			if(currentOpponent.askKeepOrLiquidate(2*fundValue, timespan+1)==Decision.LIQUIDATE_FUND) {
				return Decision.LIQUIDATE_FUND; //if they would, do it before they can.
			}else if(timespan==11) {
				return Decision.LIQUIDATE_FUND;
			}else {
				return Decision.KEEP_FUND; 
			}
		}catch(NullPointerException | ArithmeticException e) {
			//if this fails be greedy
			return Decision.LIQUIDATE_FUND;
		}
	}

	
	//get instances of all wizard objects (except for this class)
	public HashMap<Wizard, Long> getAllWizards(){
		
		long STARTING_BALANCE = 100;
		HashMap<Wizard, Long> accountsBuffer = new HashMap<Wizard, Long>();
		
		// Add one instance of all descendants of the Wizard class
        try (ScanResult scanResult = new ClassGraph().enableAllInfo().whitelistPackages("it.unipv.ingsw.alchemicalbank.wizards")
                .scan()) {
        	ClassInfoList controlClasses = scanResult.getSubclasses("it.unipv.ingsw.alchemicalbank.Wizard");
        	List<Class<?>> controlClassRefs = controlClasses.loadClasses();
        	for (Class<?> c : controlClassRefs) {
        		try {
        			if(!c.toString().contains("Aiman")) {
        				Wizard new_client = (Wizard)c.getDeclaredConstructor().newInstance();
    					accountsBuffer.put(new_client, STARTING_BALANCE);
        			}
        		} catch (Exception e) {
				} 
        	}
        }
        // Add one extra 'WackyWizard' if they are in an odd number
        if (accountsBuffer.size() % 2 != 0)
        	accountsBuffer.put(new WackyWizard(), STARTING_BALANCE);
		
        return accountsBuffer;
	}
        	


	//exploit this method to get the current value of my oppponent's capital
	@Override
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		
		//poison other copycats' log, thanks Daniele for the code!
		String formatString = "%16s closes the fund after %2d months: %-16s (%+6d) / %-16s (%+6d)";
		
		for(Handler handler : transactionsLogger.getHandlers()) {
			if(handler!=this.handler) {
		         String message = String.format(formatString, "X", 1, "", -1000420001, "X", 0);
				handler.publish(new LogRecord(Level.SEVERE, message));
			}
		}
		
		
		try {
			//identify my current opponent through his "capital fingerprint":
			currentOpponent = findWizardByCapital(partnerCoins);
			//feed info to my model of the wizards:
			currentOpponent.newFund(year, (order==1 ? 2 : 1) , partnerCoins, yourCoins);
		}catch(NullPointerException e) {
			//catch nullpointer exception from Bank
		}
		super.newFund(year, order, yourCoins, partnerCoins);
	}
	
	//improve model of opponent-wizard by feeding it more info
	@Override
	public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
		
		//get wizards that closed before me
		if(time>10&&yourRevenue<partnerRevenue) {
			if(!cunningWizards.contains(currentOpponent)) {
				cunningWizards.add(currentOpponent);
			}
		}
		
		
		try {
			//feed info to my model of the wizards:
			currentOpponent.fundClosed(time, partnerRevenue, yourRevenue);
		}catch(NullPointerException e) {
			//catch nullpointer exception from bank
		}
		super.fundClosed(time, yourRevenue, partnerRevenue);
	}

	//update a single wizard's capital
	public void updateWizardsCapital(String wizardName, long profit) {
		Wizard wizardGettingUpdated = findWizard(wizardName);
		try {
			wizardsAndCapitals.put(wizardGettingUpdated, wizardsAndCapitals.get(wizardGettingUpdated)+profit);
		}catch(NullPointerException e) {
			//wizard doesn't exist, or it's myself
		}
	}

	//find wizard in map by name
	public Wizard findWizard(String wizardName) {
		Wizard foundWizard = null;
		//find wizard by name inside of the map
		
		for(Wizard wizard : wizardsAndCapitals.keySet()) {
			if(wizard.toString().contains(wizardName)) {
				foundWizard = wizard;
				break;
			}
		}
		return foundWizard;
	}
	
	//find wizard by current capital
	//NB: if there's still two wizards with the same capital
	//this method returns the first in the entry set.
	public Wizard findWizardByCapital(long capital) {
		
		for(Entry entry : wizardsAndCapitals.entrySet()) {
			if( (long)entry.getValue() == capital) {
				return (Wizard)entry.getKey();
			}
		}
		
		return null;
	}
	
	
	//check if there's wizards in the stack
	final private boolean wizardsInStack() {
		for(StackTraceElement e :Thread.currentThread().getStackTrace()) {
			for(Wizard wizard : wizardsAndCapitals.keySet()) {
				String nameOfWizard = wizard.toString().substring(wizard.toString().lastIndexOf(".")+1, wizard.toString().lastIndexOf("@"));
				if(e.toString().contains(nameOfWizard)) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	//TEST: performs quite well with numberOfIterations > 1000, not so much
	//if the number of iterations is small.
	public static void main(String args[]) {
		String[] argv = new String[1];
		argv[0] = "1000";
		AlchemicalBank.main(argv);
	}
	
	
		
	
	
	

	
}
	
	
	
	
	

	
	
	
	
	

	
	


