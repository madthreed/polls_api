package com.madthreed.polls_api.controller;

import com.madthreed.polls_api.dto.ChoiceRequest;
import com.madthreed.polls_api.dto.PollRequest;
import com.madthreed.polls_api.dto.PollResponse;
import com.madthreed.polls_api.dto.QuestionRequest;
import com.madthreed.polls_api.model.QuestionType;
import com.madthreed.polls_api.service.PollService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestSetupController {

    private final PollService pollService;

    public TestSetupController(PollService pollService) {
        this.pollService = pollService;
    }


    @GetMapping
    public ResponseEntity<PollResponse> createPoll() {
        ChoiceRequest choiceRequest1 = ChoiceRequest.builder().text("choice1").build();
        ChoiceRequest choiceRequest2 = ChoiceRequest.builder().text("choice2").build();
        QuestionRequest questionRequest = QuestionRequest.builder()
                .questionType(QuestionType.TEXT)
                .choices(List.of(choiceRequest1, choiceRequest2))
                .build();

        PollRequest pollRequest = PollRequest.builder()
                .name("poll")
                .description("description")
                .creation_date(new Date(100L))
                .expiration_date(new Date(200L))
                .questions(List.of(questionRequest))
                .build();

        PollResponse pollResponse= pollService.createPoll(pollRequest);
        return ResponseEntity.ok(pollResponse);
    }
}
