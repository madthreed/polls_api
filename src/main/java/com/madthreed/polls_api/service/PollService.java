package com.madthreed.polls_api.service;

import com.madthreed.polls_api.dto.PollResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PollService {
    List<PollResponse> getActivePolls();

}
