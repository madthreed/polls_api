package com.madthreed.polls_api.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PollRequest {

    @NotBlank
    @Size(min = 4,max = 40)
    private String name;

    @NotBlank
    @Size(min = 4,max = 40)
    private String description;

    @NotNull
    @Valid
    private Date creation_date;

    @NotNull
    @Valid
    private Date expiration_date;

    @Valid
    private List<QuestionRequest> questions;
}
