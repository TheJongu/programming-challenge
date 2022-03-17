package de.jgu.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CSVParser {
	

	CSVReader CSVReader;

	public CSVParser(String aCSVFilePath) throws FileNotFoundException, IOException, CsvException {
		// Convert the given FilePath to a File		
		System.out.println("Parser has been created");
		try (CSVReader reader = new CSVReader(new FileReader(aCSVFilePath))) {
		      List<String[]> r = reader.readAll();
		      r.forEach(x -> System.out.println(Arrays.toString(x)));
		  }
				
	}
	
	
	
}
