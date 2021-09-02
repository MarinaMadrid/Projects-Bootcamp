package com.example.service;

import com.example.Attendee;
import com.example.Event;

public interface EventNotificationService {

    public void announce(Event event);

    public void confirmAttendance(Event event, Attendee attendee);

}
