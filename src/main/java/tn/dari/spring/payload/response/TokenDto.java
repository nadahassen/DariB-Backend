package tn.dari.spring.payload.response;

import lombok.Data;

@Data
public class TokenDto {

    private String token;
    private String username;
}