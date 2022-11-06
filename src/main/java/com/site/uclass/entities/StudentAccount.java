package com.site.uclass.entities;

import javax.persistence.*;

@Entity
@Table(name = "student_account")
public class StudentAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    public Student getStudent() {
        return this.student;
    }

    public Account getAccount() {
        return this.account;
    }
}
