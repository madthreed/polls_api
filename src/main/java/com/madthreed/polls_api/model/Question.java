package com.madthreed.polls_api.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "question")
    private String question;


    @Enumerated(EnumType.STRING)
    @Column(name = "question_type")
    private QuestionType questionType;


    @OneToMany(mappedBy = "question",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Choice> choices = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name = "poll_id", nullable = false)
    private Poll poll;


    public void addChoice(Choice choice){
        choices.add(choice);
        choice.setQuestion(this);
    }

    public void removeChoice(Choice choice){
        choices.remove(choice);
        choice.setQuestion(null);
    }
}
