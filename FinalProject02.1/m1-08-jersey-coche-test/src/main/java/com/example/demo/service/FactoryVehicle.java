package com.example.demo.service;

import com.example.demo.domain.vehicles.Vehicle;

public class FactoryVehicle {
	
	private static final String COMBUSTIONVEHICLE = "combustionVehicle";
	private static final String ELECTRICVEHICLE = "electricVehicle";
	private static final String HYBRIDVEHICLE = "hybridVehicle";

	private FactoryVehicle() {}

	public static Vehicle createByType(String type) {
		
		return switch (type) {
			case COMBUSTIONVEHICLE -> FacadeVehicle.createCombustionVehicle();
			case ELECTRICVEHICLE -> FacadeVehicle.createElectricVehicle();
			case HYBRIDVEHICLE -> FacadeVehicle.createHybridVehicle();
			default -> throw new IllegalArgumentException("Unexpected value: " + type);
		};
	}
	

}

