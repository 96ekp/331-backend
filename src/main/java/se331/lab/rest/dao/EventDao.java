package se331.lab.rest.dao;

import se331.lab.rest.entity.Event;
import java.util.List;
import se331.lab.rest.entity.Organizer;

public interface EventDao {
    Integer getEventSize();
    List<Event> getEvents(Integer pageSize, Integer page);
    Event getEvent(Long id);



    // add organizers
    Integer getOrganizerSize();
    List<Organizer> getOrganizers(Integer pageSize, Integer page);
    Event getOrganizer(Long id);

}
