package com.site.uclass.entities;

import javax.persistence.*;

@Entity
@Table(name = "professor_account")
public class ProfessorAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id", referencedColumnName = "id")
    private Professor professor;

    public Professor getProfessor() {
        return this.professor;
    }

    public Account getAccount() {
        return this.account;
    }
}
