package se331.lab.rest.service;

import se331.lab.rest.entity.Event;

import java.util.List;

public class EventService {
    public Integer getEventSize();
    public List<Event> getEvents(Integer pageSize, Integer page);
    public Event getEvent(Long id);
}