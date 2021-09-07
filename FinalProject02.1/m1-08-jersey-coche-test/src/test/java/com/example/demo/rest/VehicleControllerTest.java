package com.example.demo.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.domain.vehicles.CombustionVehicle;
import com.example.demo.domain.vehicles.ElectricVehicle;
import com.example.demo.domain.vehicles.HybridVehicle;
import com.example.demo.service.FactoryVehicle;

import javax.ws.rs.core.Response;


class VehicleControllerTest {

	VehicleController vehicleController = new VehicleController();
	
	CombustionVehicle combustionVehicle = (CombustionVehicle) FactoryVehicle.createByType(FactoryVehicle.COMBUSTIONVEHICLE);
	ElectricVehicle electricVehicle = (ElectricVehicle) FactoryVehicle.createByType(FactoryVehicle.ELECTRICVEHICLE);
	HybridVehicle hybridVehicle = (HybridVehicle) FactoryVehicle.createByType(FactoryVehicle.HYBRIDVEHICLE);
	Long id = 1L;
	
	@Test
	void helloVehicleTest() {
		Response hello = Response.ok("Hola desde VehicleController!").build();
		String mensaje = hello.getEntity().toString();
		assertEquals("Hola desde VehicleController!", mensaje);
	}
}
