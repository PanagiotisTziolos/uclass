package com.site.uclass.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.site.uclass.entities.RegisteredCourse;

public interface RegisteredCoursesRepository extends CrudRepository<RegisteredCourse, Long> {

    public List<RegisteredCourse> findByStudentId(long studentId);

    public RegisteredCourse findByCourseIdAndStudentId(long courseId, long studentId);

    public long countByStudentId(long studentId);
}
