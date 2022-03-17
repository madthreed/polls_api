package com.madthreed.polls_api.dto;

import com.madthreed.polls_api.model.QuestionType;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class QuestionRequest {

    @NotNull
    @Size(max=200)
    private String question;

    @NotNull
    @Valid
    private QuestionType questionType;

    @NotNull
    private List<ChoiceRequest> choices;
}
