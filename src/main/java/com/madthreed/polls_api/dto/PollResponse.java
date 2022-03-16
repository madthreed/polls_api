package com.madthreed.polls_api.dto;

import lombok.Builder;

import java.util.Date;
import java.util.List;

@Builder
public class PollResponse {

    private Long id;
    private String question;
    private String description;
    private Date creation_date;
    private Date expiration_date;
    private Boolean isExpired;
    private List<QuestionResponse> questions;
}
