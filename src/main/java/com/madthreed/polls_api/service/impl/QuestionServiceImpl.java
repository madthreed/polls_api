package com.madthreed.polls_api.service.impl;

import com.madthreed.polls_api.dto.PollResponse;
import com.madthreed.polls_api.dto.QuestionRequest;
import com.madthreed.polls_api.dto.QuestionResponse;
import com.madthreed.polls_api.exceptions.ResourceNotFoundException;
import com.madthreed.polls_api.model.Poll;
import com.madthreed.polls_api.model.Question;
import com.madthreed.polls_api.repo.PollRepo;
import com.madthreed.polls_api.repo.QuestionRepo;
import com.madthreed.polls_api.service.QuestionService;
import com.madthreed.polls_api.util.PollMapper;
import com.madthreed.polls_api.util.QuestionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final PollRepo pollRepo;
    private final QuestionRepo questionRepo;

    public QuestionServiceImpl(PollRepo pollRepo, QuestionRepo questionRepo) {
        this.pollRepo = pollRepo;
        this.questionRepo = questionRepo;
    }


    @Override
    public List<QuestionResponse> getQuestionsByPollId(Long pollId) {
        Poll poll = pollRepo.findById(pollId).orElseThrow(() -> new ResourceNotFoundException("Poll", "poll_id", pollId));

        List<Question> questionsByPollIs = questionRepo.getQuestionsByPollIs(poll);

        return questionsByPollIs.stream()
                .map(QuestionMapper::mapQuestionToQuestionResponse)
                .collect(Collectors.toList());
    }


    @Override
    public PollResponse createQuestionByPollId(Long pollId, QuestionRequest questionRequest) {
        Poll poll = pollRepo.findById(pollId).orElseThrow(() -> new ResourceNotFoundException("Poll", "poll_id", pollId));

        Question question = QuestionMapper.mapQuestionRequestToQuestion(questionRequest);
        poll.addQuestion(question);
        Poll saved = pollRepo.save(poll);

        return PollMapper.mapPollToPollResponse(saved);
    }


    @Override
    public QuestionResponse updateQuestionByPollAndQuestionId(Long pollId, Long questionId, QuestionRequest questionRequest) {
        Poll poll = pollRepo.findById(pollId).orElseThrow(() -> new ResourceNotFoundException("Poll", "poll_id", pollId));

        Question question = questionRepo.getQuestionsByPollIsAndId(poll, questionId);

        question.setQuestion(questionRequest.getQuestion());
        question.setQuestionType(questionRequest.getQuestionType());
        Question saved = questionRepo.save(question);

        return QuestionMapper.mapQuestionToQuestionResponse(saved);
    }


    @Override
    public void deleteQuestionByPollAndQuestionId(Long pollId, Long questionId) {
        Poll poll = pollRepo.findById(pollId).orElseThrow(() -> new ResourceNotFoundException("Poll", "poll_id", pollId));
        Question question = questionRepo.getQuestionsByPollIsAndId(poll, questionId);

        questionRepo.delete(question);
    }
}
