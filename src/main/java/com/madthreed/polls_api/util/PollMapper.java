package com.madthreed.polls_api.util;

import com.madthreed.polls_api.dto.ChoiceResponse;
import com.madthreed.polls_api.dto.PollRequest;
import com.madthreed.polls_api.dto.PollResponse;
import com.madthreed.polls_api.dto.QuestionResponse;
import com.madthreed.polls_api.model.Poll;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PollMapper {

    //todo REFACTOR THIS TO QUESTION AND CHOICE MAPPERS
    public static PollResponse mapPollToPollResponse(Poll poll) {

        Date now = new Date();
        List<QuestionResponse> questionResponses = poll.getQuestions()
                .stream()
                .map(question -> QuestionResponse
                        .builder()
                        .id(question.getId())
                        .question(question.getQuestion())
                        .questionType(question.getQuestionType())
                        .choices(question.getChoices()
                                .stream()
                                .map(choice -> ChoiceResponse
                                        .builder()
                                        .id(choice.getId())
                                        .text(choice.getText())
                                        .build())
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());

        PollResponse pollResponse = PollResponse
                .builder()
                .id(poll.getId())
                .name(poll.getName())
                .description(poll.getDescription())
                .creation_date(poll.getCreation_date())
                .expiration_date(poll.getExpiration_date())
                .isExpired(poll.getExpiration_date().after(now))
                .questions(questionResponses)
                .build();

        return pollResponse;
    }


    public static Poll mapPollRequestToPoll(PollRequest pollRequest) {
        Poll poll = new Poll();
        poll.setName(pollRequest.getName());
        poll.setDescription(pollRequest.getDescription());
        poll.setCreation_date(pollRequest.getCreation_date());
        poll.setExpiration_date(pollRequest.getExpiration_date());
        pollRequest.getQuestions().forEach(questionRequest ->
                poll.addQuestion(QuestionMapper.mapQuestionRequestToQuestion(questionRequest)));

        return poll;
    }

    //TODO IF YOU SEE THIS THEN YOU HAVE BEST REGARDS FROM ME. (madThreeD) ))))) o_O
}
