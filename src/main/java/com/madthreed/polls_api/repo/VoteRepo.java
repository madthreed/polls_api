package com.madthreed.polls_api.repo;

import com.madthreed.polls_api.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepo extends JpaRepository<Vote, Long> {
}
