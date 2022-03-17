package com.madthreed.polls_api.service;

import com.madthreed.polls_api.dto.PollRequest;
import com.madthreed.polls_api.dto.PollResponse;
import com.madthreed.polls_api.exceptions.ResourceNotFoundException;
import com.madthreed.polls_api.model.Poll;
import com.madthreed.polls_api.repo.PollRepo;
import com.madthreed.polls_api.repo.UserRepo;
import com.madthreed.polls_api.repo.VoteRepo;
import com.madthreed.polls_api.util.PollMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
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

        return polls.stream()
                .map(PollMapper::mapPollToPollResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PollResponse createPoll(PollRequest pollRequest) {
        Poll poll = PollMapper.mapPollRequestToPoll(pollRequest);
        Poll saved = pollRepo.save(poll);

        return PollMapper.mapPollToPollResponse(saved);
    }

    @Override
    public PollResponse updatePoll(Long pollId, PollRequest pollRequest) {
        Poll poll = pollRepo.findById(pollId).orElseThrow(() -> new ResourceNotFoundException("Poll", "poll_id", pollId));

        poll.setName(pollRequest.getName());
        poll.setDescription(pollRequest.getDescription());
        poll.setExpiration_date(pollRequest.getExpiration_date());

        Poll saved = pollRepo.save(poll);

        return PollMapper.mapPollToPollResponse(saved);
    }

    @Override
    public void deletePoll(Long pollId) {
        Poll poll = pollRepo.findById(pollId).orElseThrow(() -> new ResourceNotFoundException("Poll", "poll_id", pollId));

        pollRepo.delete(poll);
    }


}
