package it.unipv.ingsw.alchemicalbank.wizards;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.plaf.multi.MultiInternalFrameUI;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

//Aiman Al Masoud 472462

public class AimanAlMasoud472462 extends Wizard {

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {
		
		//get all fund values
		ArrayList<Integer> fundValues = getFundValues();
		
		//get average value of fundValues
		int averageThresholdFundValue = 0;
		for(Integer val : fundValues) {
			averageThresholdFundValue += val;
		}
		averageThresholdFundValue = averageThresholdFundValue/fundValues.size();
		
		
		
		if(fundValue >= averageThresholdFundValue) {
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
	
	//read other threshhold values 
	public ArrayList<Integer> getFundValues(){
		ArrayList<Integer> fundValues = new ArrayList<Integer>();
		
		for(File file : new File("./src/it/unipv/ingsw/alchemicalbank/wizards").listFiles()) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String lineBuffer = null;
				while((lineBuffer = reader.readLine())!=null) {
					if(lineBuffer.contains("fund")) {
						int numericValue =parseString(lineBuffer);
						if(numericValue>0 && numericValue<9999) {
							fundValues.add(numericValue);
						}
					}else if(lineBuffer.contains("timespan")) {
						int numericValue =parseString(lineBuffer);
						if(numericValue>0 && numericValue<12) {
							fundValues.add(timespanToFundValue(numericValue));
						}
					}
				}
			} catch (Exception e) {
			}	
		}
		
		return fundValues;
	}
	
	
	//parse string for number
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
	
	
	

}
