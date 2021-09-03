package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.Attendee;
import com.example.Event;
import com.example.EventType;
import com.example.Speaker;
import com.example.service.EventNotificationServiceImpl;

class EventTest {

	Event event;

	@BeforeEach
	void setUp() throws Exception {
		event = new Event();
	}

	@Test
	@DisplayName("Adding Attendee Test")
	void testAddAttendeeTest() {
		Attendee person1 = new Attendee(1L, "Marina", "marina@gmail.com");
		event.addAttendee(person1);
		assertEquals(1, event.getAttendees().size());
		assertEquals("Marina", event.getAttendees().get(0).getNickname());
	}
}
