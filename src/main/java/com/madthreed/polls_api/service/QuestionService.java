package com.madthreed.polls_api.service;

import com.madthreed.polls_api.dto.PollResponse;
import com.madthreed.polls_api.dto.QuestionRequest;
import com.madthreed.polls_api.dto.QuestionResponse;

import java.util.List;

public interface QuestionService {
    List<QuestionResponse> getQuestionsByPollId(Long pollId);

    PollResponse createQuestionByPollId(Long pollId, QuestionRequest questionRequest);

    QuestionResponse updateQuestionByPollAndQuestionId(Long pollId, Long questionId, QuestionRequest questionRequest);

    void deleteQuestionByPollAndQuestionId(Long pollId, Long questionId);
}
