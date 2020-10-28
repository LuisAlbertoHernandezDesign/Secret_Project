package com.luis.springboot.apirest.models;

import java.util.List;

public class WrapperSatelliteModel {
	
	private List<SatelliteModel> satellites;

	public List<SatelliteModel> getSatellites() {
		return satellites;
	}

	public void setSatellites(List<SatelliteModel> satellites) {
		this.satellites = satellites;
	}

}
