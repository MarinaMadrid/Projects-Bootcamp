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
	@DisplayName("Adding Null Attendee Test")
	void addNullAttendeeTest() {
		event.addAttendee(null);
		assertEquals(0, event.getAttendees().size());
	}
	
	@Test
	@DisplayName("Adding Null Attendee List Test")
	void addNullAttendeeList() throws Exception {
		Event event = new Event(1l, "Barcelona Cybersecurity Congress", EventType.TECH, new EventNotificationServiceImpl());

		event.setAttendees(null);
		assertEquals(null, event.getAttendees());
		Attendee atendee = new Attendee(1L, "Esteban", "esteban@gmail.com");
		
		event.addAttendee(atendee);
		assertEquals(1, event.getAttendees().size());
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
		assertEquals(attendees.size(), event.getAttendees().size());
	}
	
	@Test
	@DisplayName("Adding Null Attendees List Test")
	void addNullAttendeesListTest() throws Exception {
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
	@DisplayName("Removing Null Attendees Test")
	void removeNullAttendeesTest() {
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
	@DisplayName("Adding Null Speaker Test")
	void addNullSpeakerTest() {
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
	@DisplayName("Removing Null Speaker Test")
	void removeNullSpeakerTest() {
		Speaker speaker = new Speaker(1L, "Esteban", "Marketing");
		event.addSpeaker(speaker);;
		event.removeSpeaker(null);;
		assertEquals(1, event.getSpeakers().size());
	}
	
	/*
	 * Test about get and set
	 * */
	@Test
	@DisplayName("GetSet Test")
	void getSetTest() {
		event.setId(1L);
		event.setTitle("Barcelona Cybersecurity Congress");
		event.setType(EventType.TECH);
		List<Attendee> attendees = new ArrayList<Attendee>();
		event.setAttendees(attendees);
		List<Speaker> speakers = new ArrayList<Speaker>();
		event.setSpeakers(speakers);
		
		assertEquals(1L, event.getId());
		assertEquals("Barcelona Cybersecurity Congress", event.getTitle());
		assertEquals(EventType.TECH, event.getType());
		assertEquals(attendees, event.getAttendees());
		assertEquals(speakers, event.getSpeakers());
	}
}
