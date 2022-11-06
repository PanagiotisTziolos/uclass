package com.site.uclass.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.site.uclass.entities.Announcement;
import com.site.uclass.repository.AnnouncementRepository;
import com.site.uclass.services.interfaces.IAnnouncementService;


@Service
public class AnnouncementService implements IAnnouncementService {

    @Autowired
    private AnnouncementRepository repository;

    @Override
    public Iterable<Announcement> getAllAnnouncements() {
        return repository.findAll();
    }

    @Override
    public Page<Announcement> getAnnouncementPage(int pageNumber, int announcementPerPage) {
        return repository.findAll(PageRequest.of(pageNumber, announcementPerPage, Sort.by("date").descending()));
    }

    @Override
    public Announcement getAnnouncementById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public long numberOFAnnouncements() {
        return repository.count();
    }

    @Override
    public void save(Announcement announcement) {
        repository.save(announcement);
    }
}
