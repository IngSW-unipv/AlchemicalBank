package it.unipv.ingsw.alchemicalbank.wizards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
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

public class AimanDontTrackMe_AmadeiWizard471573 extends Wizard {
	HashMap<Integer, Integer> currentGame;
	boolean antithief;

	int myAllRevenue = 0;
	ArrayList<Integer> timeClosedList = new ArrayList<>();
	ArrayList<Integer> partnerClosedRevenue = new ArrayList<>();
	int currentOrder;


   public void newfund(int year, int order, long myMoney, long otherMoney) {
      this.currentGame = new HashMap<>();
      for (int i=0; i<=12; i++) {
         this.currentGame.put(i, 0);
      }
      this.antithief = false;
      this.currentOrder = order;

   }

   private Decision makeDecision(int fundValue, int timespan) {
      
      if (this.antithief) {
    	  return Decision.LIQUIDATE_FUND;
      } 
      if (timespan > 10) {
         return Decision.LIQUIDATE_FUND;
      } else {
         return Decision.KEEP_FUND;
      }
   }

   private Decision makeDecisionForThief(int fundValue, int timespan) {
      return Decision.KEEP_FUND;
   }


   public Decision askKeeporLiquidate(int fundValue, int timespan) {
      Decision result = Decision.LIQUIDATE_FUND;
      Integer current = this.currentGame.get(timespan);
      this.currentGame.put(timespan, current+1);

      if (!this.antithief && this.currentGame.get(timespan) > 1) {
         // se entro qua dentro vuol dire che è la seconda che veniamo richiamati per
         // questo timestamp in questo gioco
         this.antithief = true;
      } 

      if (this.antithief && this.currentGame.get(timespan) == 1) {         
         result = this.makeDecisionForThief(fundValue, timespan);         
      } else {
         result = this.makeDecision(fundValue, timespan);
      }

      return result;

   }

   public void fundclosed(int time, int yourRevenue, int partnerRevenue) {
      this.myAllRevenue += yourRevenue;
      this.partnerClosedRevenue.add(partnerRevenue);
      this.timeClosedList.add(time);
   }
	
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
	
	
	public AimanDontTrackMe_AmadeiWizard471573() {
		
		//add a Handler to the Logger, so as to fetch cumulative info
		//on all of the Wizards' capitals.
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
				
			});
		} catch (SecurityException e) {
			e.printStackTrace();
		} 
	}
	
	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		try {
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
		
		for(Entry<?, ?> entry : wizardsAndCapitals.entrySet()) {
			if( (long)entry.getValue() == capital) {
				return (Wizard)entry.getKey();
			}
		}
		
		return null;
	}
	
}