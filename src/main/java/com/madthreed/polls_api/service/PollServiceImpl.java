package com.madthreed.polls_api.service;

import com.madthreed.polls_api.dto.PollResponse;
import com.madthreed.polls_api.model.Poll;
import com.madthreed.polls_api.repo.PollRepo;
import com.madthreed.polls_api.repo.UserRepo;
import com.madthreed.polls_api.repo.VoteRepo;
import com.madthreed.polls_api.util.DtoMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class PollServiceImpl implements PollService {
    private final PollRepo pollRepo;
    private final UserRepo userRepo;
    private final VoteRepo voteRepo;

    public PollServiceImpl(PollRepo pollRepo, UserRepo userRepo, VoteRepo voteRepo) {
        this.pollRepo = pollRepo;
        this.userRepo = userRepo;
        this.voteRepo = voteRepo;
    }

    @Override
    public List<PollResponse> getActivePolls() {

        List<Poll> polls = pollRepo.findAll();

        List<PollResponse> activePolls = polls.stream()
                .map(DtoMapper::mapPollToPollResponse)
                .collect(Collectors.toList());

        return activePolls;
    }
}
