package com.madthreed.polls_api.controller;

import com.madthreed.polls_api.dto.PollRequest;
import com.madthreed.polls_api.dto.PollResponse;
import com.madthreed.polls_api.service.PollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/polls")
public class PollsController {

    private final PollService pollService;

    public PollsController(PollService pollService) {
        this.pollService = pollService;
    }


    @GetMapping
    public List<PollResponse> getActivePolls() {

        return pollService.getActivePolls();
    }


    @PostMapping
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PollResponse> createPoll(@Valid @RequestBody PollRequest pollRequest) {

        PollResponse pollResponse= pollService.createPoll(pollRequest);
        return ResponseEntity.ok(pollResponse);
    }


    @PutMapping("/{pollId}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PollResponse> updatePoll(@PathVariable Long pollId, @Valid @RequestBody PollRequest pollRequest) {

        PollResponse pollResponse = pollService.updatePoll(pollId, pollRequest);
        return ResponseEntity.ok(pollResponse);
    }


    @DeleteMapping("/{pollId}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
        pollService.deletePoll(pollId);

        return ResponseEntity.ok("Poll deleted successfully");
    }
}
