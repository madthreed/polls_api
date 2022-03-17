package com.madthreed.polls_api.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class ChoiceResponse {

    private Long id;
    private String text;
}
