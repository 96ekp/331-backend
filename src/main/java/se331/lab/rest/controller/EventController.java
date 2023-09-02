package se331.lab.rest.controller;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
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
import org.springframework.http.HttpHeaders;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;



@Controller
@RequiredArgsConstructor
public class EventController {
final EventService eventService;
    @GetMapping("events")
    public ResponseEntity<?> getEventLists(
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value= "_page", required = false) Integer page){

        List<Event> output = null;
        Integer eventSize = eventService.getEventSize();

        HttpHeaders responseHeader = new HttpHeaders();

        responseHeader.set("x.total-count", String.valueOf(eventSize));

        try{
            output = eventService.getEvents(perPage, page);
            return new ResponseEntity<>(output, responseHeader, HttpStatus.OK);

        } catch (IndexOutOfBoundsException ex){
            return new ResponseEntity<>(output, responseHeader, HttpStatus.OK);

        }
        }

    @GetMapping("events/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
        Event output = eventService.getEvent(id);
        if(output != null) {
            return ResponseEntity.ok(output);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

// add organizer
@GetMapping("organizers")
public ResponseEntity<?> getOrganizerLists(
        @RequestParam(value = "_limit", required = false) Integer perPage,
        @RequestParam(value= "_page", required = false) Integer page){

    List<Organizer> output = null;
    Integer eventSize = eventService.getOrganizerSize();

    HttpHeaders responseHeader = new HttpHeaders();

    responseHeader.set("x.total-count", String.valueOf(eventSize));

    try{
        output = eventService.getOrganizers(perPage, page);
        return new ResponseEntity<>(output, responseHeader, HttpStatus.OK);

    } catch (IndexOutOfBoundsException ex){
        return new ResponseEntity<>(output, responseHeader, HttpStatus.OK);

    }
}

    @GetMapping("organizer/{id}")
    public ResponseEntity<?> getOrganizer(@PathVariable("id") Long id) {
        Event output = eventService.getOrganizer(id);
        if(output != null) {
            return ResponseEntity.ok(output);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }
}
