package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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
	void addAttendeeTest() {
		Attendee person1 = new Attendee(1L, "Marina", "marina@gmail.com");
		event.addAttendee(person1);
		assertEquals(1, event.getAttendees().size());
		assertEquals("Marina", event.getAttendees().get(0).getNickname());
	}
	
	@Test
	@DisplayName("Adding Attendee Null Test")
	void addAttendeeNullTest() {
		event.addAttendee(null);
		assertEquals(0, event.getAttendees().size());
	}
	
	@Test
	@DisplayName("Adding Attendee List Null Test")
	void addAttendeeListNull() throws Exception {
		Event evento = new Event(1l, "Barcelona Cybersecurity Congress", EventType.TECH, new EventNotificationServiceImpl());

		evento.setAttendees(null);
		assertEquals(null, evento.getAttendees());
		Attendee person1 = new Attendee(1L, "Esteban", "esteban@gmail.com");
		
		evento.addAttendee(person1);
		assertEquals(1, evento.getAttendees().size());
	}
	
	@Test
	@DisplayName("Adding Attendess Test")
	void addAttendeesTest() {
		List<Attendee> attendees = new ArrayList<Attendee>();
		Attendee person1 = new Attendee(1L, "Marina", "marina@gmail.com");
		Attendee person2 = new Attendee(2L, "Esteban", "esteban@gmail.com");
		attendees.add(person1);
		attendees.add(person2);
		event.addAttendees(attendees);
	}
	
}
