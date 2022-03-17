package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.jgu.parser.CSVParser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {

    private String successLabel = "not successful";

    @BeforeEach
    void setUp() {
        successLabel = "successful";
    }

    @Test
    void aPointlessTest() {
        assertEquals("successful", successLabel, "My expectations were not met");
    }

    @Test
    void runFootball() {
        App.main("--football", "football.csv");
    }
    

    @Test
    void footballFileExists() {
    	// A file with name football.csv in resources dir is available
   	 	assertTrue(App.getWeatherPath().endsWith("src\\main\\resources\\de\\exxcellent\\challenge\\football.csv"));
    }

    @Test
    void weaterFileExists() {
    	// A file with name weather.csv in resources dir is available 
    	assertTrue(App.getWeatherPath().endsWith("src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv"));
    }
    
    @Test
    void parsingTest() {
    	CSVParser theParser = new CSVParser();
    	
    	// File has been parsed successfully
    	assertTrue(theParser.parseFile(App.getFootballPath()));
    	assertTrue(theParser.parseFile(App.getWeatherPath()));    	
    }

}