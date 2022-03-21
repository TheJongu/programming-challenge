package de.jgu.parser;


import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;

public class CSVParser {
	
	// Named columns
	protected List<String> headLine;
	// Values in the CSV
	// List[ ] = row in the file
	// String[index] = column of the row (each Index, one cell)
	protected List<String[]> values;

	public CSVParser(){
		// Create empty Parser
	}
	
	/**
	 * Parses a given Path to a CSV File into the internal headLine and values Attributes
	 * @param aCSVFilePath full path to csv file
	 * @return boolean if Parsing was successful
	 */
	public boolean parseFile(String aCSVFilePath) {
		// new File is parsed, remove old information
		headLine = null;
		values = null;
		
		try (CSVReader reader = new CSVReader(new FileReader(aCSVFilePath))) {
			// Using CSVReader to Read the File
			List<String[]> csvRowList = reader.readAll();
			Iterator<String[]> csvIterator = csvRowList.iterator();
			// Parse Data
			while(csvIterator.hasNext()) {
				String[] nextRow = csvIterator.next();
				// headline
				// first time running: Headline == null -> Set Headline
				if(headLine == null) {
					headLine = new ArrayList<String>();
					for(int i = 0; i < nextRow.length; i++) {
						headLine.add(nextRow[i]);
					}
					continue;
				}
				// everytime except first time -> Add value of CSV to values list
				// Body of Csv
				if(values == null) {
					values = new ArrayList<String[]>();
				}
				values.add(nextRow);
			}
		    // file has been parsed successfully
		    return true;
		    
		}catch(Exception e) {
			// A full and correct logging concept should be used
			System.out.print("An Exception occured" + e.toString());
			// Something went wrong, tell the user the file has not been parsed
			return false;
		}
	}
	
	/**
	 * Parse a int from aCell
	 * @param aCell the Cell from a Row
	 * @return int Value from the Cell
	 */
	protected int parseIntValueFromCell(String aCell) {
		// unhandled exception will stop the programm
		return Integer.parseInt(aCell.trim());
		
	}
	
	/**
	 * Parse a double from aCell
	 * @param aCell the Cell from a Row
	 * @return double Value from the Cell
	 */
	protected double parseDoubleValueFromCell(String aCell) {
		// unhandled exception will stop the programm
		return Double.parseDouble(aCell.trim());
	}
	/**
	 * Print the parsed File
	 */
	public void printParsedFile() {
		if(headLine == null) {
			System.out.println("No File Parsed");
			return;
		}
		// Print headline
		this.headLine.stream().forEach(s -> System.out.print(s.toString() + ", "));
		// print values in Rows
		this.values.stream().forEach(s -> {
			String outputString = "";
			for(int i = 0; i<s.length; i++) {
				outputString += s[i] + ", "; 
			}
			System.out.println(outputString);
		});
	}
	
	// generated getter
	public List<String> getHeadLine() {
		return headLine;
	}

	public List<String[]> getValues() {
		return values;
	}	
}
