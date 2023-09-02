package se331.lab.rest.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Organizer extends Event {
    Long id;
    String organizationName;
    String address;

}