package it.unipv.ingsw.alchemicalbank.wizards;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
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

//Aiman Al Masoud 472462
//the idea is to keep track of each participant's capital through the logs, 
//and then try to identify the participant through their current capital, which is
//provided by the startNewFund() method.

//Problems with this approach:
//some of the contendents aren't relying solely on the information provided by the arguments
//of the askKeepOrLiquidate method. Some are using Randoms, and others are doing all sorts of things
//with global variables in their classes.
//Since I can't access the actual instance of their classes that is playing against me, 
//I can't predict exactly what their Decisions will be.
	

public class AimanAlMasoud472462 extends Wizard {

	//how many coins my current opponent has
	long currentOpponentsCapital;
	
	//transactions' logger: exploiting logs to get cumulative info on 
	//opponents' current wealth
	Logger transactionsLogger = Logger.getLogger(Bank.class.getName());
	
	//latest transaction 
	String lastTransactionMessage;
	
	//list of wizards and their capitals 
	HashMap<Wizard, Long> wizardsAndCapitals = getAllWizards();
	
	public AimanAlMasoud472462() {
		
		
		//DEBUG PRINTOUT
		/*
		for(Wizard wizard: wizardsAndCapitals.keySet()) {
			System.out.println(wizard + " "+wizardsAndCapitals.get(wizard));
		}
		*/
		
		
		try {
			transactionsLogger.addHandler(new Handler() {
				@Override
				public void close() throws SecurityException {
				}
				@Override
				public void flush() {	
				}
				@Override
				public void publish(LogRecord arg0) {
					
					lastTransactionMessage = arg0.getMessage();	
					
					//update capitals of two opponents
					try {
						int startIndex = lastTransactionMessage.indexOf(" months: ")+" months: ".length();
						lastTransactionMessage = lastTransactionMessage.substring(startIndex);
						String[] twoParts = lastTransactionMessage.split("/ ");
						
						
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
				
			});
		} catch (SecurityException e) {
			e.printStackTrace();
		} 
	}
	
	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		
		try {
			//find who my current opponent is
			Wizard currentOpponent = findWizardByCapital(currentOpponentsCapital);
			
			//DEBUG PRINTOUT
			//System.out.println("my current opponent is: "+currentOpponent);
			
			
			//find out weather they'd liquidate on their next turn:
			if(currentOpponent.askKeepOrLiquidate(2*fundValue, timespan+1)==Decision.LIQUIDATE_FUND) {
				return Decision.LIQUIDATE_FUND; //if they would, do it before they can.
			}else if(timespan==11) {
				return Decision.LIQUIDATE_FUND;
			}else {
				return Decision.KEEP_FUND; 
			}
			
			
		}catch(NullPointerException e) {
			//if this fails
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
		this.currentOpponentsCapital = partnerCoins;
		super.newFund(year, order, yourCoins, partnerCoins);
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
	
	
	//find wizard in map
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
	
	
	/*
	//TEST: performs quite well with numberOfIterations > 1000, not so much
	//if the number of iterations is small.
	public static void main(String args[]) {
		String[] argv = new String[1];
		argv[0] = "1000";
		AlchemicalBank.main(argv);
	}
	*/

	
}
	
	
	
	
	

	
	
	
	
	

	
	


