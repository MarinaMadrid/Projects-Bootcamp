package tests.testsService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.domain.vehicles.CombustionVehicle;
import com.example.demo.domain.vehicles.ElectricVehicle;
import com.example.demo.domain.vehicles.HybridVehicle;
import com.example.demo.domain.vehicles.Vehicle;
import com.example.demo.service.FactoryVehicle;

class FactoryVehicleTest {

	@Test
	void testCombustionVehicleInstance() {
		// ejecucion del codigo a testear
		Vehicle combustionVehicle = FactoryVehicle.createByType("combustionVehicle");

		// verificaciones
		assertNotNull(combustionVehicle);
		assertTrue(combustionVehicle instanceof CombustionVehicle);
		assertEquals("Default combustionVehicle", combustionVehicle.getName());
		assertEquals(1L, combustionVehicle.getId());
	}

	@Test
	void testElectricVehicleInstance() {
		// ejecucion del codigo a testear
		Vehicle electricVehicle = FactoryVehicle.createByType("electricVehicle");

		// verificaciones
		assertNotNull(electricVehicle);
		assertTrue(electricVehicle instanceof ElectricVehicle);
		assertEquals("Default electricVehicle", electricVehicle.getName());
		assertEquals(1L, electricVehicle.getId());
	}

	@Test
	void testhybridVehicleInstance() {
		// ejecucion del codigo a testear
		Vehicle hybridVehicle = FactoryVehicle.createByType("hybridVehicle");

		// verificaciones
		assertNotNull(hybridVehicle);
		assertTrue(hybridVehicle instanceof HybridVehicle);
		assertEquals("Default hybridVehicle", hybridVehicle.getName());
		assertEquals(1L, hybridVehicle.getId());
	}

	@Test
	void testDefaultInstance() {
		// ejecucion del codigo a testear
		Exception exception = assertThrows(IllegalArgumentException.class,
				() -> FactoryVehicle.createByType("notexists"));

		assertEquals("Unexpected value: notexists", exception.getMessage());

	}

}
