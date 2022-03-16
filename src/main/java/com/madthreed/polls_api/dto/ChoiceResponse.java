package com.madthreed.polls_api.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChoiceResponse {

    private Long id;
    private String text;
}
