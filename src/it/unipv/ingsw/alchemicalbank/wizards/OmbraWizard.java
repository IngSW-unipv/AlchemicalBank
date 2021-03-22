//package it.unipv.ingsw.alchemicalbank.wizards;
//	import java.util.logging.Logger;
//	import java.util.ArrayList;
//	import java.util.HashMap;
//	import it.unipv.ingsw.alchemicalbank.Decision;
//	import it.unipv.ingsw.alchemicalbank.Wizard;
////6 OF THESE WIZARD CAN KILL ANYONE USING LOGGER TO SEE OTHER PEOPLE RESULTS. 
//	
//	public class OmbraWizard extends Wizard {
//	
//		static HashMap<Long, Integer[]> games = new HashMap<>();
//		   static HashMap<Long, Boolean> thieveGames = new HashMap<>();
//		   
//		   boolean antithief = false;
//
//		   Long counter;
//		   Long oldCounter;
//
//		   private void buildCurrentGame(Long timestamp) {      
//		      this.games.put(timestamp, new Integer[13]);
//		      for (int i=0; i<13; i++) {
//		         this.games.get(timestamp)[i] = 0;
//		      }      
//		      this.thieveGames.put(timestamp, false);
//		   }
//
//		   @Override
//		   public void newFund(int year, int order, long myMoney, long otherMoney) { 
//		           
//		   }
//
//		   @Override
//		   public Decision askKeepOrLiquidate(int fundValue, int timespan) {
//		      this.counter = System.currentTimeMillis();
//		      Long hash = this.counter;      
//		      if (timespan == 1 || timespan == 2) {         
//		         this.buildCurrentGame(this.counter);         
//		      } else {
//		         if (this.oldCounter != null && this.counter - this.oldCounter > 1) {
//		            this.buildCurrentGame(this.counter);            
//		         } else if (this.oldCounter == null) {
//		            this.buildCurrentGame(this.counter);            
//		         }
//		      }
//		      if (timespan > 2 && this.games.get(this.oldCounter) != null) {
//		         this.games.put(this.counter, this.games.get(this.oldCounter));
//		         this.thieveGames.put(this.counter, this.thieveGames.get(this.oldCounter));                
//		      }
//		      this.oldCounter = this.counter;
//		      Decision result;
//
//		      if (this.games.get(hash) == null) {         
//		      }
//		      int current = this.games.get(hash)[timespan] + 1;
//		      this.games.get(hash)[timespan] += 1;      
//
//		      if (!this.thieveGames.get(hash).booleanValue() && current > 1) {
//		         // se entro qua dentro vuol dire che � la seconda che veniamo richiamati per
//		         // questo timestamp in questo gioco
//		         this.thieveGames.put(hash, true);         
//		      } 
//
//		      if (this.thieveGames.get(hash).booleanValue() && current == 1) {         
//		         result = this.makeDecisionForThief(fundValue, timespan);         
//		      } else {
//		         result = this.makeDecision(this.thieveGames.get(hash).booleanValue(), fundValue, timespan);
//		      }
//
//		      return result;
//		   }
//
//		   private Decision makeDecision(boolean antithief, int fundValue, int timespan) {            
//		      if (antithief) {              
//		         return Decision.LIQUIDATE_FUND;
//		      } 
//		      if (timespan > 10) {
//		         return Decision.LIQUIDATE_FUND;
//		      } else {         
//		         return Decision.KEEP_FUND;
//		      }
//		   }
//
//		   private Decision makeDecisionForThief(int fundValue, int timespan) {
//		      return Decision.KEEP_FUND;
//		   }
//
//		   @Override
//		   public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
//		      //this.myAllRevenue += yourRevenue;
//		   }
//
//	}