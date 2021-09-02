package tests.testsRest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.rest.HelloController;

class HelloControllerTest {
	HelloController helloController = new HelloController();

	@Test
	void helloTest() {
		String hello = helloController.hello();
		assertEquals("Bienvenidos a Compramostucoche.es", hello);
	}

}
