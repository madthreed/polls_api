package com.madthreed.polls_api.util;

import com.madthreed.polls_api.dto.ChoiceResponse;
import com.madthreed.polls_api.dto.QuestionRequest;
import com.madthreed.polls_api.dto.QuestionResponse;
import com.madthreed.polls_api.model.Question;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionMapper {

    public static Question mapQuestionRequestToQuestion(QuestionRequest questionRequest) {
        Question question = new Question();
        question.setQuestion(questionRequest.getQuestion());
        question.setQuestionType(questionRequest.getQuestionType());
        questionRequest.getChoices().forEach(choiceRequest ->
                question.addChoice(ChoiceMapper.mapChoiceRequestToChoice(choiceRequest)));

        return question;
    }

    public static QuestionResponse mapQuestionToQuestionResponse(Question question) {
        List<ChoiceResponse> choiceResponses = question.getChoices().stream()
                .map(choice -> ChoiceResponse.builder()
                        .id(choice.getId())
                        .text(choice.getText())
                        .build())
                .collect(Collectors.toList());


        QuestionResponse questionResponse = QuestionResponse.builder()
                .id(question.getId())
                .question(question.getQuestion())
                .questionType(question.getQuestionType())
                .choices(choiceResponses)
                .build();

        return questionResponse;
    }
}
