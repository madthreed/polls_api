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
public class VotesController {

//    private final VoteService voteService;
//
//    public VotesController(VoteService voteService) {
//        this.voteService = voteService;
//    }
//
//    @PostMapping("/{pollId}/votes")
//    @PreAuthorize("hasRole('USER')")
//    public PollResponse castVote(@CurrentUser UserPrincipal currentUser,
//                                 @PathVariable Long pollId,
//                                 @Valid @RequestBody VoteRequest voteRequest){
//
//        return pollService.castVoteAndGetUpdatedPoll(pollId,voteRequest,currentUser);
//    }
}
