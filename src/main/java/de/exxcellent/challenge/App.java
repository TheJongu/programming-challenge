package de.exxcellent.challenge;

import java.io.File;
import java.util.List;
import java.util.Optional;

import de.jgu.football.FootballDTO;
import de.jgu.football.FootballParser;
import de.jgu.weather.WeatherDTO;
import de.jgu.weather.WeatherParser;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {
	
    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        String dayWithSmallestTempSpread = findDayWithSmallestTempSpread(); 
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = findDayWithSmallestGoalSpread();
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
    
    /**
     * Task 1: Find the smallest Temp Spread
     * @return the Day
     */
    private static String findDayWithSmallestTempSpread(){
    	WeatherParser theWeatherParser =  new WeatherParser();
    	theWeatherParser.parseFile(App.getWeatherPath());
    	List<WeatherDTO> theWeatherDtos = theWeatherParser.convertToWeatherDTO();
    	// get lowest WeatherSpread
    	Optional<WeatherDTO> theOptional = theWeatherDtos.stream()
    			.min((dto1, dto2) -> Integer.compare(
	    			Math.abs(dto1.getMxt() - dto1.getMnt()), 
	    			Math.abs(dto2.getMxt() - dto2.getMnt())));
    	if(theOptional.isEmpty()) {
    		return "No day found";
    	}
    	return String.valueOf(theOptional.get().getDay());
    }
    
    /**
     * Task 2: Find the smallest Goal Spread
     * @return the Teamname.
     */
    private static String findDayWithSmallestGoalSpread(){
    	FootballParser theFootballParser =  new FootballParser();
    	theFootballParser.parseFile(App.getFootballPath());
    	List<FootballDTO> theFootballDtos = theFootballParser.convertToFootballDTO();
    	// get lowest GoalSpread
    	Optional<FootballDTO> theOptionalDTO = theFootballDtos.stream()
    			.min((dto1, dto2) -> Integer.compare(
	    			Math.abs(dto1.getGoals() - dto1.getGoalsAllowed()), 
	    			Math.abs(dto2.getGoals() - dto2.getGoalsAllowed())));
    	if(theOptionalDTO.isEmpty()) {
    		return "No Team found";
    	}
    	return String.valueOf(theOptionalDTO.get().getTeam());
    }
    
    /**
     * @return the Path to the Weather File
     */
    public static String getWeatherPath() {
    	 //	Only for Windows
    	return getProjectPath() + "\\src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv";
    }
    /**
     * @return the Path to the Football File
     */
    public static String getFootballPath() {
    	//	Only for Windows	
    	return getProjectPath() + "\\src\\main\\resources\\de\\exxcellent\\challenge\\football.csv";
    }
    /**
     * @return Get the Path to the Project
     */
    public static String getProjectPath() {
    	//	Only for Windows
    	String thePath = new File(".").getAbsolutePath();
    	// remove trailing \ and .
    	return thePath.substring(0, thePath.length() - 2);
    }
}
