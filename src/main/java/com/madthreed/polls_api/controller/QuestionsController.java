package com.madthreed.polls_api.controller;

import com.madthreed.polls_api.dto.QuestionRequest;
import com.madthreed.polls_api.dto.QuestionResponse;
import com.madthreed.polls_api.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/poll")
public class QuestionsController {

    private final QuestionService questionService;

    public QuestionsController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping("/{pollId}")
    @PreAuthorize("hasRole('USER')")
    public List<QuestionResponse> getQuestionsByPollId(@PathVariable Long pollId) {

        return questionService.getQuestionsByPollId(pollId);
    }


    @PostMapping("/{pollId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<QuestionResponse> createQuestionByPollId(
            @PathVariable Long pollId,
            @Valid @RequestBody QuestionRequest questionRequest) {

        QuestionResponse questionResponse= questionService.createQuestionByPollId(pollId, questionRequest);
        return ResponseEntity.ok(questionResponse);
    }


    @PutMapping("/{pollId}/question/{questionId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<QuestionResponse> updateQuestionByPollAndQuestionId(
            @PathVariable Long pollId, @PathVariable Long questionId,
            @Valid @RequestBody QuestionRequest questionRequest) {

        QuestionResponse questionResponse = questionService.updateQuestionByPollAndQuestionId(pollId, questionId, questionRequest);
        return ResponseEntity.ok(questionResponse);
    }


    @DeleteMapping("/{pollId}/question/{questionId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteQuestionByPollAndQuestionId(
            @PathVariable Long pollId, @PathVariable Long questionId) {

        questionService.deleteQuestionByPollAndQuestionId(pollId, questionId);
        return ResponseEntity.ok("Question deleted successfully");
    }
}
