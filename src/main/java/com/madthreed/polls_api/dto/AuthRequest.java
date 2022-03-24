package com.madthreed.polls_api.dto;

import lombok.*;


@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AuthRequest {
    private String username;
    private String password;
}
