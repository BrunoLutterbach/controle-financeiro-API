package br.com.brunolutterbach.alurachallengebackend.DTO;

import lombok.Getter;

@Getter
public class TokenDTO {

    private String token;
    private String tipo;

    public TokenDTO(String token, String tipo) {
        this.token = token;
        this.tipo = tipo;
    }
}
