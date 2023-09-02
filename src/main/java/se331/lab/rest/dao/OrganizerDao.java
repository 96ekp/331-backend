package se331.lab.rest.dao;

import se331.lab.rest.entity.Organizer;
import java.util.List;

public interface OrganizerDao {
    // add organizers
    public Integer getOrganizerSize();
    public List<Organizer> getOrganizers(Integer pageSize, Integer page);
    public Organizer getOrganizer(Long id);
}
