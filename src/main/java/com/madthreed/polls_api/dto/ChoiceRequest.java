package com.madthreed.polls_api.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ChoiceRequest {

    @NotNull
    @Size(max=100)
    private String text;
}
