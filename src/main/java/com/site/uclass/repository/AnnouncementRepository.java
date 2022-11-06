package com.site.uclass.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.site.uclass.entities.Announcement;

public interface AnnouncementRepository extends PagingAndSortingRepository<Announcement, Long> {

}
