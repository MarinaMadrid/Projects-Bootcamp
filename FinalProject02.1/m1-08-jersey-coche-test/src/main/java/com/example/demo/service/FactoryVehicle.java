package com.example.demo.service;

import com.example.demo.domain.vehicles.Vehicle;

public class FactoryVehicle {
	
	private static final String COMBUSTIONVEHICLE = "combustionvehicle";
	private static final String ELECTRICVEHICLE = "electricvehicle";
	private static final String HYBRIDVEHICLE = "hybridvehicle";

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

