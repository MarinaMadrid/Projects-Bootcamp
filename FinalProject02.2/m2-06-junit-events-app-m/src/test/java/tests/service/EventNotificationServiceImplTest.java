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
	}
	
	@Test
	@DisplayName("Announcing an event")
	void announceTest() {
		inEvent.notifyAssistants();
		verify(mockEventNotificationServiceImpl, times(1)).announce(inEvent);
	}
	
	
}
