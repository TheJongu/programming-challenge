package de.jgu.parser;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;

import de.jgu.weather.WeatherDTO;

public class CSVParser {
	
	private CSVReader CSVReader;
	// Named columns
	protected List<String> headLine;
	// Values in the CSV
	// List[ ] = row in the file
	// String[index] = column of the row
	protected List<String[]> values;

	public CSVParser(){
		// Create empty Parser
		System.out.println("Parser has been created");
	}
	
	public boolean parseFile(String aCSVFilePath) {
		// new File is parsed, remove old information
		headLine = null;
		values = null;
		CSVReader = null;
		
		try (CSVReader reader = new CSVReader(new FileReader(aCSVFilePath))) {
			List<String[]> csvRowList = reader.readAll();
		    
			Iterator<String[]> csvIterator = csvRowList.iterator();
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
