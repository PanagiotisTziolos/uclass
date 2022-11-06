package com.site.uclass.entities;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "content", columnDefinition="LONGTEXT" )
    private String content;

    @OneToOne(
        mappedBy = "answer"
    )
    private Question question;

    public Answer() {}

    public long getId() {
        return id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Question getQuestion() {
        return question;
    }
}
