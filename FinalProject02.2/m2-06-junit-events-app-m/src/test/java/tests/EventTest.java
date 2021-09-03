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
	
	/*
	 * Tests about an attendee
	 * */
	
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
	@DisplayName("Removing Attendee Test")
	void removeAttendeeTest() {
		Attendee attendee = new Attendee(1L , "Marina", "marina@gmail.com");
		event.addAttendee(attendee);
		event.removeAttendee(attendee);
		assertEquals(0, event.getAttendees().size());
	}
	

	@Test
	@DisplayName("Removing Attendee Null Test")
	void removeAttendeeNullTest() {
		Attendee attendee = new Attendee(1L , "Marina", "marina@gmail.com");
		event.addAttendee(attendee);
		event.removeAttendee(null);
		assertEquals(1, event.getAttendees().size());
	}
	
	
	/*
	 * Tests about an ArrayList<attendees>
	 * */
	@Test
	@DisplayName("Adding Attendees Test")
	void addAttendeesTest() {
		List<Attendee> attendees = new ArrayList<Attendee>();
		Attendee attendee1 = new Attendee(1L, "Marina", "marina@gmail.com");
		Attendee attendee2 = new Attendee(2L, "Esteban", "esteban@gmail.com");
		attendees.add(attendee1);
		attendees.add(attendee2);
		event.addAttendees(attendees);
	}
	
	@Test
	@DisplayName("Adding Attendees List Null Test")
	void addAttendeesListNullTest() throws Exception {
		event.setAttendees(null);
		List<Attendee> attendees = new ArrayList<Attendee>();
		Attendee attendee = new Attendee(1L, "Marina", "marina@gmail.com");
		attendees.add(attendee);
		event.addAttendees(attendees);
		assertEquals(event.getAttendees().size(), 1);
	}
	

	@Test
	@DisplayName("Removing Attendees Test")
	void removeAttendeesTest() {
		List<Attendee> attendees = new ArrayList<Attendee>();
		Attendee attendee = new Attendee(1L, "Marina", "marina@gmail.com");
		attendees.add(attendee);
		event.addAttendees(attendees);
		event.removeAttendees(attendees);
		assertEquals(0, event.getAttendees().size());
	}
	
	@Test
	@DisplayName("Removing Attendees Null Test")
	void removeAttendeesNullTest() {
		List<Attendee> attendees = null;
	    event.removeAttendees(attendees);
		assertEquals(0, event.getAttendees().size());
	}
	
	/*
	 * Tests about a speaker
	 * */
	@Test
	@DisplayName("Adding Speaker Test")
	void addSpeakerTest() {
		Speaker speaker = new Speaker(1L, "Esteban", "Marketing");
		event.addSpeaker(speaker);;
		assertEquals(1, event.getSpeakers().size());
	}
	
	@Test
	@DisplayName("Adding Speaker Null Test")
	void addSpeakerNullTest() {
		event.addSpeaker(null);;
		assertEquals(0, event.getSpeakers().size());
	}
	
	@Test
	@DisplayName("Removing Speaker Test")
	void removeSpeakerTest() {
		Speaker speaker = new Speaker(1L, "Esteban", "Marketing");
		event.addSpeaker(speaker);
		event.removeSpeaker(speaker);
		assertEquals(0, event.getSpeakers().size());
	}
	
	@Test
	@DisplayName("Removing Speaker Null Test")
	void removeSpeakerNullTest() {
		Speaker speaker = new Speaker(1L, "Esteban", "Marketing");
		event.addSpeaker(speaker);;
		event.removeSpeaker(null);;
		assertEquals(1, event.getSpeakers().size());
	}
	
	
}
