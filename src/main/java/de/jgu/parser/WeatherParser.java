package de.jgu.parser;

import java.util.ArrayList;
import java.util.List;

import de.jgu.weather.WeatherDTO;

public class WeatherParser extends CSVParser{

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

	private WeatherDTO convertRowIntoDTO(String[] aRow) {
		WeatherDTO theWeatherDTO = new WeatherDTO();
		// day
		theWeatherDTO.setDay(Integer.parseInt(aRow[0]));
		// mxt
		theWeatherDTO.setMxt(Integer.parseInt(aRow[1]));
		// Mnt
		theWeatherDTO.setMnt(Integer.parseInt(aRow[2]));
		// Avt
		theWeatherDTO.setAvt(Integer.parseInt(aRow[3]));
		 // avdp
		theWeatherDTO.setAvdp(Integer.parseInt(aRow[4]));
		// HrP TPcpn
		theWeatherDTO.setHrp_pcpn(Integer.parseInt(aRow[5]));
		// PDir
		theWeatherDTO.setPdir(Integer.parseInt(aRow[6]));
		// AvSp
		theWeatherDTO.setAvsp(Integer.parseInt(aRow[7]));
		// Dir
		theWeatherDTO.setDir(Integer.parseInt(aRow[8]));
		// MxS
		theWeatherDTO.setMxs(Integer.parseInt(aRow[9]));
		// SkyC
		theWeatherDTO.setSkyc(Integer.parseInt(aRow[10]));
		//MxR
		theWeatherDTO.setMxr(Integer.parseInt(aRow[11]));
		//Mn
		theWeatherDTO.setMn(Integer.parseInt(aRow[12]));
		//R_AvSLP
		theWeatherDTO.setR_avslp(Integer.parseInt(aRow[13]));
		return theWeatherDTO;
	}
	
}
