package tests.testsRest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import com.example.demo.rest.VehicleController;
import com.sun.research.ws.wadl.Response;

class VehicleControllerTest {
	VehicleController vehicleController;

	@Test
	void helloVehicleTest() {
		vehicleController.hello();
		//assertEquals(Response.ok());
	}

}
