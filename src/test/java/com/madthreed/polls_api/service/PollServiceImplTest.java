package com.madthreed.polls_api.service;

import com.madthreed.polls_api.dto.*;
import com.madthreed.polls_api.model.Poll;
import com.madthreed.polls_api.model.QuestionType;
import com.madthreed.polls_api.repo.PollRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
class PollServiceImplTest {
//    @Autowired
//    private PollService pollService;

//    @MockBean
//    private PollRepo pollRepo;

    @Test
    void getActivePolls() {
    }

    @Test
    void createPoll() {
//        ChoiceRequest choiceRequest1 = ChoiceRequest.builder().text("choice1").build();
//        ChoiceRequest choiceRequest2 = ChoiceRequest.builder().text("choice2").build();
//        QuestionRequest questionRequest = QuestionRequest.builder()
//                .questionType(QuestionType.TEXT)
//                .choices(List.of(choiceRequest1,choiceRequest2))
//                .build();
//
//        PollRequest pollRequest = PollRequest.builder()
//                .name("poll")
//                .description("description")
//                .creation_date(new Date(100L))
//                .expiration_date(new Date(200L))
//                .questions(List.of(questionRequest))
//                .build();
//
//        pollService.createPoll(pollRequest);
//
//        Mockito.verify(pollRepo, Mockito.times(1))
//                .save(ArgumentMatchers.any(Poll.class));
    }

    @Test
    void updatePoll() {
    }

    @Test
    void deletePoll() {
    }
}