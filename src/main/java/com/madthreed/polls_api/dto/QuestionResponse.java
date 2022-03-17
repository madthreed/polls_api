package com.madthreed.polls_api.dto;

import com.madthreed.polls_api.model.QuestionType;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class QuestionResponse {

    private Long id;
    private String question;
    private QuestionType questionType;
    private List<ChoiceResponse> choices;
}
