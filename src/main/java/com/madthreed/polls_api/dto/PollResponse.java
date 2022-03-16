package com.madthreed.polls_api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Builder
@Data
public class PollResponse {

    private Long id;
    private String name;
    private String description;
    private Date creation_date;
    private Date expiration_date;
    private Boolean isExpired;
    private List<QuestionResponse> questions;
}
