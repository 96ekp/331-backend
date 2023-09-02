package se331.lab.rest.service;

import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;

import java.util.List;


public interface EventService {
    public Integer getEventSize();
    public List<Event> getEvents(Integer pageSize, Integer page);
    public Event getEvent(Long id);

}
