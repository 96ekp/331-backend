package se331.lab.rest.service;


import org.springframework.beans.factory.annotation.Autowired;
import se331.lab.rest.dao.OrganizerDao;
import se331.lab.rest.entity.Organizer;
import org.springframework.stereotype.Service;
import java.util.List;

public class OrganizerServiceImpl implements OrganizerService {
    @Autowired
    OrganizerDao organizeDao;


    @Override
    public Integer getOrganizerSize() {
        return organizeDao.getOrganizerSize();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        return organizeDao.getOrganizers(pageSize, page);
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return (Organizer) organizeDao.getOrganizer(id);
    }
}
