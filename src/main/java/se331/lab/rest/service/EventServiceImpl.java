package se331.lab.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.dao.EventDao;
import se331.lab.rest.entity.Event;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventDao eventDao;
    // organizer
    EventDao organizeDao;
    @Override
    public Integer getEventSize() {
        return eventDao.getEventSize();
    }
    // organizer
    @Override
    public Integer getOrganizerSize() {
        return organizeDao.getOrganizerSize();
    }

    @Override
    public List<Event> getEvents(Integer pageSize, Integer page) {
        return eventDao.getEvents(pageSize, page);
    }
    // organizer
    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        return organizeDao.getOrganizers(pageSize, page);
    }

    @Override
    public Event getEvent(Long id) {
        return eventDao.getEvent(id);
    }
    // organizer
    @Override
    public Organizer getOrganizer(Long id) {
        return (Organizer) organizeDao.getOrganizer(id);
    }
}

