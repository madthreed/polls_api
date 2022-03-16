package com.madthreed.polls_api.controller;

import com.madthreed.polls_api.dto.PollResponse;
import com.madthreed.polls_api.service.PollService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/polls")
public class PollsController {

    private final PollService pollService;

    public PollsController(PollService pollService) {
        this.pollService = pollService;
    }


    @GetMapping
    public PollResponse getActivePolls() {

        return pollService.getActivePolls();
    }
}
