package se331.lab.rest.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Event;
import java.util.ArrayList;
import java.util.List;
import se331.lab.rest.entity.Organizer;
@Repository
public class EventDaoImpl implements EventDao {
    List<Event> eventList;
    List<Organizer> eventList2;

    @PostConstruct
    public void init() {
        eventList = new ArrayList<>();
        eventList.add(Event.builder()
                .id(123L)
                .category("animal welfare")
                .title("Cat Adoption Day")
                .description("Find your new feline friend at this event.")
                .location("Meow Town")
                .date("January 28, 2022")
                .time("12.00")
                .petAllowed(true)
                .organizer("Kat Laydee")
                .build());
        eventList.add(Event.builder()
                .id(456L)
                .category("food")
                .title("Community Gardening")
                .description("Join us as we tend to the community edible plants.")
                .location("Flora City")
                .date("March 14, 2022")
                .time("10:00")
                .petAllowed(true)
                .organizer("Fern Pollin")
                .build());
        eventList.add(Event.builder()
                .id(789L)
                .category("sustainability")
                .title("Beach Cleanup")
                .description("Help pick up trash along the shore.")
                .location("Playa Del Carmen")
                .date("July 22, 2022")
                .time("11:00")
                .petAllowed(false)
                .organizer("Carey Wales")
                .build());
        eventList.add(Event.builder()
                .id(1001L)
                .category("animal welfare")
                .title("Dog Adoption Day")
                .description("Find your new canine friend at this event.")
                .location("Woof Town")
                .date("August 28, 2022")
                .time("12:00")
                .petAllowed(true)
                .organizer("Dawg Dahd")
                .build());
        eventList.add(Event.builder()
                .id(1002L)
                .category("food")
                .title("Canned Food Drive")
                .description("Bring your canned food to donate to those in need.")
                .location("Tin City")
                .date("September 14, 2022")
                .time("3:00")
                .petAllowed(true)
                .organizer("Kahn Opiner")
                .build());
        eventList.add(Event.builder()
                .id(1003L)
                .category("sustainability")
                .title("Highway Cleanup")
                .description("Help pick up trash along the highway.")
                .location("Highway 50")
                .date("July 22, 2022")
                .time("11:00")
                .petAllowed(false)
                .organizer("Brody Kill")
                .build());


        // Organizer
        eventList2 = new ArrayList<>();
        eventList2.add(Organizer.builder()
                .id(1L)
                .organizationName("Name1")
                .address("address1")
                .build());
        eventList2.add(Organizer.builder()
                .id(2L)
                .organizationName("Name2")
                .address("address2")
                .build());
        eventList2.add(Organizer.builder()
                .id(3L)
                .organizationName("Name3")
                .address("address3")
                .build());
        eventList2.add(Organizer.builder()
                .id(4L)
                .organizationName("Name4")
                .address("address4")
                .build());
        eventList2.add(Organizer.builder()
                .id(5L)
                .organizationName("Name5")
                .address("address5")
                .build());
        eventList2.add(Organizer.builder()
                .id(6L)
                .organizationName("Name6")
                .address("address6")
                .build());

    }

    @Override
    public Integer getEventSize() {
        return eventList.size();
    }
    // organizer
    @Override
    public Integer getOrganizerSize() {
        return eventList2.size();
    }

    @Override
    public List<Event> getEvents(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? eventList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page -1 ) * pageSize;
        return eventList.subList(firstIndex,firstIndex+pageSize);
    }
    // organizer

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? eventList2.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page -1 ) * pageSize;
        return eventList2.subList(firstIndex,firstIndex+pageSize);
    }
    @Override
    public Event getEvent(Long id) {
        return eventList.stream().filter(event->
                event.getId().equals(id)).findFirst().orElse(null);
    }
    // organizer
    @Override
    public Organizer getOrganizer(Long id) {
        return eventList2.stream().filter(event->
                organizer.getId().equals(id)).findFirst().orElse(null);
    }
}
