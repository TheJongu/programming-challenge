package de.jgu.football;

import java.util.ArrayList;
import java.util.List;

import de.jgu.parser.CSVParser;

/**
 * Parser for a Football CSV File
 * Data will be parsed into a {@link FootballDTO}
 *
 */
public class FootballParser extends CSVParser{

	/**
	 * Convert the stored Data in the Parser to a WeatherDTO List
	 * @return List<WeatherDTO>
	 */
	public List<FootballDTO> convertToFootballDTO(){
		List<FootballDTO> theWeatherDTOList = new ArrayList<FootballDTO>();
		// Check if a file has been parsed
		if(headLine == null || values == null) {
			// Nothing has been parsed, so a empty list is returned
			return theWeatherDTOList;
		}
		for(String[] aRow: values) {
			theWeatherDTOList.add(convertRowIntoDTO(aRow));
		}		
		return theWeatherDTOList;
	}

	/**
	 * Convert a given Row to a Weather DTO
	 * @param aRow Row to be converted to DTO.
	 * @return weatherDTO matching the Row
	 */
	private FootballDTO convertRowIntoDTO(String[] aRow) {
		FootballDTO theFootballDTO = new FootballDTO();
		// Team
		theFootballDTO.setTeam(aRow[0].trim());
		// Games
		theFootballDTO.setGames(parseIntValueFromCell(aRow[1].trim()));
		// Wins
		theFootballDTO.setWins(parseIntValueFromCell(aRow[2].trim()));
		// Losses
		theFootballDTO.setLosses(parseIntValueFromCell(aRow[3].trim()));
		 // Draws
		theFootballDTO.setDraws(parseIntValueFromCell(aRow[4].trim()));
		// Goals
		theFootballDTO.setGoals(parseIntValueFromCell(aRow[5].trim()));
		// GoalsAllowed
		theFootballDTO.setGoalsAllowed(parseIntValueFromCell(aRow[6].trim()));
		// Points
		theFootballDTO.setPoints(parseIntValueFromCell(aRow[7].trim()));
		return theFootballDTO;
	}
}
