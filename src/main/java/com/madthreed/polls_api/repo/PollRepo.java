package com.madthreed.polls_api.repo;

import com.madthreed.polls_api.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(collectionResourceRel = "poll", path = "poll")
@Repository
public interface PollRepo extends JpaRepository<Poll,Long> {
}
