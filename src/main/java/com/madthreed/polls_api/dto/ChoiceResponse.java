package com.madthreed.polls_api.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ChoiceResponse {

    private Long id;
    private String text;
}
