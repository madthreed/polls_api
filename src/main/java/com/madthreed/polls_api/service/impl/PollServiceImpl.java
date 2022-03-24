package com.madthreed.polls_api.service.impl;

import com.madthreed.polls_api.dto.PollRequest;
import com.madthreed.polls_api.dto.PollResponse;
import com.madthreed.polls_api.exceptions.ResourceNotFoundException;
import com.madthreed.polls_api.model.Poll;
import com.madthreed.polls_api.repo.PollRepo;
import com.madthreed.polls_api.repo.UserRepo;
import com.madthreed.polls_api.repo.VoteRepo;
import com.madthreed.polls_api.service.PollService;
import com.madthreed.polls_api.util.PollMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PollServiceImpl implements PollService {
    private final PollRepo pollRepo;

    public PollServiceImpl(PollRepo pollRepo) {
        this.pollRepo = pollRepo;
    }

    @Override
    public List<PollResponse> getActivePolls() {

        List<Poll> polls = pollRepo.findAll();
        log.info("IN findAll - {} polls found", polls.size());

        return polls.stream()
                .map(PollMapper::mapPollToPollResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PollResponse createPoll(PollRequest pollRequest) {
        Poll poll = PollMapper.mapPollRequestToPoll(pollRequest);
        Poll saved = pollRepo.save(poll);
        log.info("IN createPoll - {} poll successfully created", poll);

        return PollMapper.mapPollToPollResponse(saved);
    }

    @Override
    public PollResponse updatePoll(Long pollId, PollRequest pollRequest) {
        Poll poll = pollRepo.findById(pollId).orElseThrow(() -> new ResourceNotFoundException("Poll", "poll_id", pollId));

        poll.setName(pollRequest.getName());
        poll.setDescription(pollRequest.getDescription());
        poll.setExpiration_date(pollRequest.getExpiration_date());

        Poll saved = pollRepo.save(poll);
        log.info("IN updatePoll - {} poll successfully updated", poll);

        return PollMapper.mapPollToPollResponse(saved);
    }

    @Override
    public void deletePoll(Long pollId) {
        Poll poll = pollRepo.findById(pollId).orElseThrow(() -> new ResourceNotFoundException("Poll", "poll_id", pollId));

        pollRepo.delete(poll);
        log.info("IN deletePoll - poll with id: {} successfully deleted", pollId);
    }


}
