package it.unipv.ingsw.alchemicalbank.wizards;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;




import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

//Aiman Al Masoud 472462
//This wizard takes a statistical approach on the matter of liquidating his fund or not.

public class AimanAlMasoud472462 extends Wizard {

	
	//critical/threshold fund values of (most) of the other contendents.
	//ie: the fund values at which each other wizard liquidates their funds.
	ArrayList<Integer> fundValues; 
	
	public AimanAlMasoud472462() {
		//get all of the critical fund values
		fundValues = getFundValues();
	}
	
	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		
		//if getDistribution(fundValue) > 0.5, it's likely that 
		//my opponent would liquidate if given a chance to, 
		//so I'll liquidate before they can do it.
		if(getDistribution(fundValue)>=0.5) {
			return Decision.LIQUIDATE_FUND;
		}else {
			return Decision.KEEP_FUND;
		}
	}
	
	
	//fundValue can be derived from timespan.
	//get fundValue from time span
	public int timespanToFundValue(int timespan) {
		return (int)(20*Math.pow(2, timespan-1));
	}
	
	//read threshhold fund values from other Wizards
	public ArrayList<Integer> getFundValues(){
		ArrayList<Integer> fundValues = new ArrayList<Integer>();
		
		//list all of the Wizards' source code files
		for(File file : new File("./src/it/unipv/ingsw/alchemicalbank/wizards").listFiles()) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String lineBuffer = null;
				while((lineBuffer = reader.readLine())!=null) {
					if(lineBuffer.contains("fund")) {
						int numericValue =parseString(lineBuffer);
						if(numericValue>0 && numericValue<41000) {
							fundValues.add(numericValue);
						}
					}else if(lineBuffer.contains("timespan")) {
						int numericValue =parseString(lineBuffer);
						if(numericValue>0 && numericValue<12) {
							fundValues.add(timespanToFundValue(numericValue));
						}
					}
				}
				reader.close();
			} catch (Exception e) {
			}
			
		}
		
		return fundValues;
	}
	
	
	//parse string for a number
	public int parseString(String line) {
		String buffer = "";
		for(int i = 0; i<line.length(); i++) {
			if(Character.isDigit(line.charAt(i))) {
				buffer+=line.charAt(i);
			}
		}
		
		try {
			return Integer.parseInt(buffer);
		}catch(NumberFormatException e) {
			return -1;
		}
	}
	
	
	//sort by fund value (which is the KEY of these Entries). In ascending order.
	public ArrayList<Entry<Integer, Integer>> getSortedFreqList() {
		
		  HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
			//get all frequencies
			for(Integer num : fundValues) {
				if(freqMap.containsKey(num)) {
					freqMap.put(num, freqMap.get(num)+1);
				}else {
					freqMap.put(num, 1);
				}
			}
		   
		//get sorted list of entries
			ArrayList<Entry<Integer, Integer>> list = new ArrayList<>(freqMap.entrySet());
			
			Collections.sort(list, new Comparator<Entry>() {
				@Override
				public int compare(Entry arg0, Entry arg1) {
					return (int)arg0.getKey() - (int)arg1.getKey();
				}
			});
			
		return list;
	}
	
	
	//F() distribution function. Input= fundValue, output= cumulative frequency
	public Float getDistribution(int fundValue) {
		ArrayList<Entry<Integer, Integer>> list = getSortedFreqList();
		float accumul = 0;
		
		for(Entry entry : list) {
			Integer value = (Integer)entry.getValue();
			accumul += (float)value/fundValues.size();
			
			if(fundValue <= (Integer)entry.getKey()) {
				return accumul;
			}
		}
		
		return accumul;
	}
	
	
	
	/*
	public static void main(String args[]) {
		
		AimanAlMasoud472462 wizard = new AimanAlMasoud472462();
		
		
	}
	*/
	
	

}
