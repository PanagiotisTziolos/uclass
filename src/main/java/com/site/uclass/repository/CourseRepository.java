package com.site.uclass.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.site.uclass.entities.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {
    public Optional<Course> findByName(String name);
}
