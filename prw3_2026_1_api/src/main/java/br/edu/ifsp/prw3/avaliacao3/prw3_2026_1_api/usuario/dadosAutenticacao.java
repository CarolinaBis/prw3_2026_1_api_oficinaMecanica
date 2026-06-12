package br.edu.ifsp.prw3.avaliacao3.prw3_2026_1_api.usuario;

import jakarta.validation.constraints.NotBlank;

public record dadosAutenticacao(

        @NotBlank
        String login,

        @NotBlank
        String senha) {

}
