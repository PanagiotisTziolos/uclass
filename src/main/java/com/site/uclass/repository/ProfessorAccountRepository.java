package com.site.uclass.repository;

import org.springframework.data.repository.CrudRepository;

import com.site.uclass.entities.ProfessorAccount;

public interface ProfessorAccountRepository extends CrudRepository<ProfessorAccount, Long> {

    public ProfessorAccount findByAccountId(long id);
}
