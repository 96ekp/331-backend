package se331.lab.rest.service;
import se331.lab.rest.entity.Organizer;
import java.util.List;

public interface OrganizerService {
    public Integer getOrganizerSize();
    public List<Organizer> getOrganizers(Integer pageSize, Integer page);
    public Organizer getOrganizer(Long id);
}
