package com.site.uclass.services.interfaces;

import org.springframework.data.domain.Page;

import com.site.uclass.entities.Announcement;

public interface IAnnouncementService {
    
    public Iterable<Announcement> getAllAnnouncements();

    public Page<Announcement> getAnnouncementPage(int pageNumber, int announcementPerPage);

    public Announcement getAnnouncementById(long id);

    public long numberOFAnnouncements();

    public void save(Announcement announcement);
}
