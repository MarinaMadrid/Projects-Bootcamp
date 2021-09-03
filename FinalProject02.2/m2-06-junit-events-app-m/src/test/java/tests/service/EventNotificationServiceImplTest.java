package tests.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Attendee;
import com.example.Event;
import com.example.EventType;
import com.example.service.EventNotificationServiceImpl;

@ExtendWith(MockitoExtension.class)
class EventNotificationServiceImplTest {
	
	EventNotificationServiceImpl eventNotificationServiceImpl;
	Event event;
	Attendee attendee;
	
	@Mock
	EventNotificationServiceImpl mockEventNotificationServiceImpl;
	Event mockEvent;
	
	@InjectMocks
	Event inEvent;

	@BeforeEach
	void setUp() throws Exception {
		eventNotificationServiceImpl = new EventNotificationServiceImpl();
		attendee = new Attendee();
		event = new Event();
	}
	
	/*
	 * Tests about announcing an event
	 * */
	
	@Test
	@DisplayName("Announcing Event Test")
	void announceTest() {
		inEvent.notifyAssistants();
		verify(mockEventNotificationServiceImpl, times(1)).announce(inEvent);
	}
	
	@Test
	@DisplayName("Announcing Null Event Test")
	void announceNullEventTest() {
		Attendee attendee = new Attendee(1L , "Marina", "marina@gmail.com");
		Event event = new Event(1l, "Barcelona Cybersecurity Congress", EventType.TECH, new EventNotificationServiceImpl());
		event.addAttendee(attendee);
		eventNotificationServiceImpl.announce(null);
		assertEquals(0, attendee.getNotifications().size());
	}
	
	@Test
	@DisplayName("Announcing Null Attendees Test")
	void announceNullAttendeesTest() {
		Attendee attendee = new Attendee(1L , "Marina", "marina@gmail.com");
		Event event = new Event(1l, "Barcelona Cybersecurity Congress", EventType.TECH, new EventNotificationServiceImpl());
		event.setAttendees(null);
		eventNotificationServiceImpl.announce(event);
		assertEquals(0, attendee.getNotifications().size());
	}
	
	@Test
	@DisplayName("Announcing Without Attendees Test")
	void announceWithoutAttendeesTest() {
		Attendee attendee = new Attendee(1L , "Marina", "marina@gmail.com");
		Event event = new Event(1l, "Barcelona Cybersecurity Congress", EventType.TECH, new EventNotificationServiceImpl());
		event.addAttendee(attendee);
		event.getAttendees().clear();
		event.notifyAssistants();
		assertEquals(0, attendee.getNotifications().size());
	}
	
	/*
	 * Tests about confirming attendance an event
	 * */
	
	@Test
	@DisplayName("Confirming Attendance Event Test")
	void confirmAttendanceEventTest() {
		Attendee attendee = new Attendee(1L , "Marina", "marina@gmail.com");
		Event event = new Event(1l, "Barcelona Cybersecurity Congress", EventType.TECH, new EventNotificationServiceImpl());
		event.addAttendee(attendee);
		event.notifyAssistants();
		eventNotificationServiceImpl.confirmAttendance(event,attendee);
		assertEquals("Dear Attendee, your subscription to the event has been confirmed successfully.", attendee.getNotifications().get(1).getMessage());
	}
	
	@Test
	@DisplayName("Confirming Attendance Null Event Test")
	void confirmAttendanceNullEventTest() {
		Attendee attendee = new Attendee(1L , "Marina", "marina@gmail.com");
		Event event = new Event(1l, "Barcelona Cybersecurity Congress", EventType.TECH, new EventNotificationServiceImpl());
		event.addAttendee(attendee);
		eventNotificationServiceImpl.confirmAttendance(null,attendee);
		assertEquals(0, attendee.getNotifications().size());
	}
	
	@Test
	@DisplayName("Confirming Attendance Null Attendee Test")
	void confirmAttendanceNullAttendeeTest() {
		Attendee attendee = new Attendee(1L , "Marina", "marina@gmail.com");
		Event event = new Event(1l, "Barcelona Cybersecurity Congress", EventType.TECH, new EventNotificationServiceImpl());
		event.addAttendee(attendee);
		eventNotificationServiceImpl.confirmAttendance(event,null);
		assertEquals(0, attendee.getNotifications().size());
	}
	
}
