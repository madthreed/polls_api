package com.madthreed.polls_api.service;

import com.madthreed.polls_api.dto.PollResponse;
import org.springframework.stereotype.Service;

@Service
public interface PollService {
    PollResponse getActivePolls();

}
