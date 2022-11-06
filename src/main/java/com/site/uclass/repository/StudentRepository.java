package com.site.uclass.repository;

import org.springframework.data.repository.CrudRepository;

import com.site.uclass.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
    public Student findByName(String name);
}
