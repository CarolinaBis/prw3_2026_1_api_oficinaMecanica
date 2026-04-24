package br.edu.ifsp.prw3.avaliacao3.prw3_2026_1_api.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosVeiculo(
        @NotBlank
        String marca,

        @NotBlank
        String modelo,

        @NotBlank
        @Pattern(regexp = "\\d{4}")
        String ano,

        String cor
) {}
