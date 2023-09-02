package se331.lab.rest.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.rest.entity.Event;
import java.util.ArrayList;
import java.util.List;


@Controller
public class EventController {
    List<Event> eventList;
    @GetMapping("event")
    public ResponseEntity<?> getEventLists(
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value= "_page", required = false) Integer page){
        perPage = perPage == null?eventList.size():perPage;
        page = page  == null?1:page;
        Integer firstIndex = (page -1) * perPage;
        List<Event> output = new ArrayList<>();

        try{
            for(int i = firstIndex; i < firstIndex + perPage; i++){
                output.add(eventList.get(i));
            }
            return ResponseEntity.ok(output);
        } catch (IndexOutOfBoundsException ex){
            return  ResponseEntity.ok(output);
        }
        }

    @GetMapping("event/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
        Event output = null;
        for(Event event : eventList) {
            if(event.getId().equals(id)) {
                output = event;
                break;
            }
        }
        if(output != null) {
            return ResponseEntity.ok(output);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }




    @PostConstruct
    public void init(){
        eventList= new ArrayList<>();
        eventList.add(Event.builder()
                .id(123L)
                .category("animal welfare")
                .title("Cat Adoption Day")
                .description("Find your new feline friend at this event.")
                .location("Meow Town")
                .date("January 28, 2022")
                .time("12:00")
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
                .category("music")
                .title("Summer Music Festival")
                .description("Enjoy a day of live music and fun in the sun.")
                .location("Sunset Park")
                .date("July 15, 2022")
                .time("15:00")
                .petAllowed(false)
                .organizer("Melody Masters")
                .build());

        eventList.add(Event.builder()
                .id(101L)
                .category("sports")
                .title("Charity Fun Run")
                .description("Join us for a charity run to support a good cause.")
                .location("Central Park")
                .date("April 5, 2022")
                .time("09:30")
                .petAllowed(false)
                .organizer("Run for Charity")
                .build());

        eventList.add(Event.builder()
                .id(222L)
                .category("arts")
                .title("Art Exhibition Opening")
                .description("Explore the works of talented local artists.")
                .location("Gallery 123")
                .date("May 20, 2022")
                .time("18:00")
                .petAllowed(false)
                .organizer("Artistic Expressions")
                .build());

        eventList.add(Event.builder()
                .id(333L)
                .category("technology")
                .title("Tech Conference 2022")
                .description("Stay updated with the latest tech trends and innovations.")
                .location("Tech Center")
                .date("September 8, 2022")
                .time("09:00")
                .petAllowed(false)
                .organizer("TechConnect")
                .build());

        eventList.add(Event.builder()
                .id(555L)
                .category("health")
                .title("Fitness and Wellness Expo")
                .description("Explore fitness and wellness products and services.")
                .location("Wellness Arena")
                .date("June 10, 2022")
                .time("11:30")
                .petAllowed(false)
                .organizer("Wellness World")
                .build());

        eventList.add(Event.builder()
                .id(777L)
                .category("education")
                .title("STEM Workshop for Kids")
                .description("Engage kids in science, technology, engineering, and math activities.")
                .location("KidsTech Lab")
                .date("October 2, 2022")
                .time("14:00")
                .petAllowed(false)
                .organizer("STEM Education Foundation")
                .build());


    }
}
