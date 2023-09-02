package se331.lab.rest.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizerDaoImpl implements OrganizerDao{
    List<Organizer> eventList2;

    @PostConstruct
    public void init() {
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
    public Integer getOrganizerSize() {
        return eventList2.size();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? eventList2.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return eventList2.subList(firstIndex, firstIndex + pageSize);
    }
    @Override
    public Organizer getOrganizer(Long id) {
        return eventList2.stream().filter(organizer ->
                organizer.getId().equals(id)).findFirst().orElse(null);
    }
}
