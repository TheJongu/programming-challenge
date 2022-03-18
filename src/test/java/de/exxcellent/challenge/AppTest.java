package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.jgu.football.FootballDTO;
import de.jgu.football.FootballParser;
import de.jgu.parser.CSVParser;
import de.jgu.weather.WeatherDTO;
import de.jgu.weather.WeatherParser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

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
    
    @BeforeEach
    void footballFileExists() {
    	// A file with name football.csv in resources dir is available
   	 	assertTrue(App.getWeatherPath().endsWith("src\\main\\resources\\de\\exxcellent\\challenge\\football.csv"));
    }

    @BeforeEach
    void weatherFileExists() {
    	// A file with name weather.csv in resources dir is available 
    	assertTrue(App.getWeatherPath().endsWith("src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv"));
    }

    @Test
    void runFootball() {
        App.main("--football", "football.csv");
    }

    @Test
    void parsingTest() {
    	CSVParser theParser = new CSVParser();
    	
    	// File has been parsed successfully
    	assertTrue(theParser.parseFile(App.getFootballPath()));
    	assertTrue(theParser.parseFile(App.getWeatherPath()));    	
    }
    
    @Test
    void weatherParserTest() {
    	// A file with name weather.csv in resources dir is available 
    	WeatherParser theWeatherParser = new WeatherParser();
    	List<WeatherDTO> theWeatherDTOList = theWeatherParser.convertToWeatherDTO();
    	assertNull(theWeatherDTOList);
    	
    	theWeatherParser.parseFile(App.getFootballPath());
    	theWeatherDTOList = theWeatherParser.convertToWeatherDTO();
    	// expect at least a list object
    	assertNotNull(theWeatherDTOList);
    	// expect at least one dto object in the list
    	assertTrue(theWeatherDTOList.size() > 0, "theWeatherDTOList has not been populated with Objects");
    }
    
    @Test
    void footballParserTest() {
    	// A file with name weather.csv in resources dir is available 
    	FootballParser theWeatherParser = new FootballParser();
    	List<FootballDTO> theFootballDTOList = theWeatherParser.convertToFootballDTO();
    	// no file Read; Empty Result
    	assertNull(theFootballDTOList);
    	
    	theWeatherParser.parseFile(App.getFootballPath());
    	theFootballDTOList = theWeatherParser.convertToFootballDTO();
    	// expect at least a list object
    	assertNotNull(theFootballDTOList);
    	// expect at least one dto object in the list
    	assertTrue(theFootballDTOList.size() > 0, "FootballDTOList has not been populated with Objects"); 
    }

}