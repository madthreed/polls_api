package com.madthreed.polls_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "polls")
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "poll_name")
    private String name;


    @DateTimeFormat
    @Column(name = "start_date")
    private Date start_date;


    @DateTimeFormat
    @Column(name = "expiration_date")
    private Date expiration_date;


    @Column(name = "description")
    private String description;


    @OneToMany(mappedBy = "poll",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Question> questions = new ArrayList<>();


    public void addQuestion(Question question) {
        questions.add(question);
        question.setPoll(this);
    }


    public void removeQuestion(Question question) {
        questions.remove(question);
        question.setPoll(null);
    }


}
