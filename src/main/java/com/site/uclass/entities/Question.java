package com.site.uclass.entities;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "content", columnDefinition="LONGTEXT" )
    private String content;

    @OneToOne(
        fetch = FetchType.LAZY,
        optional = false,
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name = "answer_id",
        nullable = false
    )
    private Answer answer;

    public Question() {}
    
    public long getId() {
        return id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Answer getAnswer() {
        return answer;
    }
}
