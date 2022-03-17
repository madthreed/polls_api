package com.madthreed.polls_api.service;

import com.madthreed.polls_api.dto.PollRequest;
import com.madthreed.polls_api.dto.PollResponse;

import java.util.List;

public interface PollService {
    List<PollResponse> getActivePolls();

    PollResponse createPoll(PollRequest pollRequest);

    PollResponse updatePoll(Long id, PollRequest pollRequest);

    void deletePoll(Long id);
}
