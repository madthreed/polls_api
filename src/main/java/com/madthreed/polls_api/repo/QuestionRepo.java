package com.madthreed.polls_api.repo;

import com.madthreed.polls_api.model.Poll;
import com.madthreed.polls_api.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Long> {
    List<Question> getQuestionsByPollIs(Poll poll);
    Question getQuestionsByPollIsAndId(Poll poll, Long questionId);
}
