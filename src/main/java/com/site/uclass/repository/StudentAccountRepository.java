package com.site.uclass.repository;

import org.springframework.data.repository.CrudRepository;

import com.site.uclass.entities.StudentAccount;

public interface StudentAccountRepository extends CrudRepository<StudentAccount, Long> {

    public StudentAccount findByAccountId(long id);
}
