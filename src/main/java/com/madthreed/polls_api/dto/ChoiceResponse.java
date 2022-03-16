package com.madthreed.polls_api.dto;

import lombok.Builder;

@Builder
public class ChoiceResponse {

    private Long id;
    private String text;
}
