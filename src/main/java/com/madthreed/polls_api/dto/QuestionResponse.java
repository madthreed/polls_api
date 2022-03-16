package com.madthreed.polls_api.dto;

import com.madthreed.polls_api.model.QuestionType;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class QuestionResponse {

    private Long id;
    private String question;
    private QuestionType questionType;
    private List<ChoiceResponse> choices;
}
