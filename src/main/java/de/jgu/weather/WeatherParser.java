package de.jgu.weather;

import java.util.ArrayList;
import java.util.List;

import de.jgu.parser.CSVParser;

/**
 * Parser for a Weather CSV File
 * Data will be parsed into a {@link WeatherDTO}
 * 
 */
public class WeatherParser extends CSVParser{

	/**
	 * Convert the stored Data in the Parser to a WeatherDTO List
	 * @return List<WeatherDTO>
	 */
	public List<WeatherDTO> convertToWeatherDTO(){
		List<WeatherDTO> theWeatherDTOList = new ArrayList<WeatherDTO>();
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
	 * @param aRow Row to be converted to dto
	 * @return weatherDTO matching the Row
	 */
	private WeatherDTO convertRowIntoDTO(String[] aRow) {
		WeatherDTO theWeatherDTO = new WeatherDTO();
		// day
		theWeatherDTO.setDay(parseIntValueFromCell(aRow[0].trim()));
		// mxt
		theWeatherDTO.setMxt(parseIntValueFromCell(aRow[1].trim()));
		// Mnt
		theWeatherDTO.setMnt(parseIntValueFromCell(aRow[2].trim()));
		// Avt
		theWeatherDTO.setAvt(parseIntValueFromCell(aRow[3].trim()));
		 // avdp
		theWeatherDTO.setAvdp(parseDoubleValueFromCell(aRow[4].trim()));
		// HrP TPcpn
		theWeatherDTO.setHrp_pcpn(parseIntValueFromCell(aRow[5].trim()));
		// PDir
		theWeatherDTO.setPdir(parseIntValueFromCell(aRow[6].trim()));
		// AvSp
		theWeatherDTO.setAvsp(parseDoubleValueFromCell(aRow[7].trim()));
		// Dir
		theWeatherDTO.setDir(parseIntValueFromCell(aRow[8].trim()));
		// MxS
		theWeatherDTO.setMxs(parseIntValueFromCell(aRow[9].trim()));
		// SkyC
		theWeatherDTO.setSkyc(parseDoubleValueFromCell(aRow[10].trim()));
		//MxR
		theWeatherDTO.setMxr(parseIntValueFromCell(aRow[11].trim()));
		//Mn
		theWeatherDTO.setMn(parseIntValueFromCell(aRow[12].trim()));
		//R_AvSLP
		theWeatherDTO.setR_avslp(parseDoubleValueFromCell(aRow[13].trim()));
		return theWeatherDTO;
	}
}
