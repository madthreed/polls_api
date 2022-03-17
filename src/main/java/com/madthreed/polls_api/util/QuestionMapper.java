package com.madthreed.polls_api.util;

import com.madthreed.polls_api.dto.QuestionRequest;
import com.madthreed.polls_api.model.Question;

public class QuestionMapper {

    public static Question mapQuestionRequestToQuestion(QuestionRequest questionRequest) {
        Question question = new Question();
        question.setQuestion(questionRequest.getQuestion());
        question.setQuestionType(questionRequest.getQuestionType());
        questionRequest.getChoices().forEach(choiceRequest ->
                question.addChoice(ChoiceMapper.mapChoiceRequestToChoice(choiceRequest)));

        return question;
    }
}
