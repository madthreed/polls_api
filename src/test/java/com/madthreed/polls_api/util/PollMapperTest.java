package com.madthreed.polls_api.util;

import com.madthreed.polls_api.dto.ChoiceResponse;
import com.madthreed.polls_api.dto.PollResponse;
import com.madthreed.polls_api.dto.QuestionResponse;
import com.madthreed.polls_api.model.Choice;
import com.madthreed.polls_api.model.Poll;
import com.madthreed.polls_api.model.Question;
import com.madthreed.polls_api.model.QuestionType;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PollMapperTest {

    @Test
    void mapPollToPollResponseTest() {
        Choice choice1 = new Choice();
        choice1.setId(1L);
        choice1.setText("choice1");

        Choice choice2 = new Choice();
        choice2.setId(2L);
        choice2.setText("choice2");

        Question question = new Question();
        question.setId(1L);
        question.setQuestionType(QuestionType.TEXT);
        question.addChoice(choice1);
        question.addChoice(choice2);

        Poll poll = new Poll();
        poll.setId(1L);
        poll.setName("poll");
        poll.setDescription("description");
        poll.setCreation_date(new Date(100L));
        poll.setExpiration_date(new Date(200L));
        poll.addQuestion(question);


        ChoiceResponse choiceResponse1 = ChoiceResponse.builder().id(1L).text("choice1").build();
        ChoiceResponse choiceResponse2 = ChoiceResponse.builder().id(2L).text("choice2").build();
        QuestionResponse questionResponse = QuestionResponse.builder()
                .id(1L)
                .questionType(QuestionType.TEXT)
                .choices(List.of(choiceResponse1,choiceResponse2))
                .build();

        PollResponse expectedPollResponse = PollResponse.builder()
                .id(1L)
                .name("poll")
                .description("description")
                .creation_date(new Date(100L))
                .expiration_date(new Date(200L))
                .isExpired(false)
                .questions(List.of(questionResponse))
                .build();

        PollResponse actualPollResponse = PollMapper.mapPollToPollResponse(poll);

        assertEquals(expectedPollResponse, actualPollResponse);
    }
}