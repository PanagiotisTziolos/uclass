package com.site.uclass.repository;

import org.springframework.data.repository.CrudRepository;

import com.site.uclass.entities.PassedCourse;

public interface PassedCoursesRepository extends CrudRepository<PassedCourse, Long> {

    public Iterable<PassedCourse> findByStudentId(long studentId);
}
