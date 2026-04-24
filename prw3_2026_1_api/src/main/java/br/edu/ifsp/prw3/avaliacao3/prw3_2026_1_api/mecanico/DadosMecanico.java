package br.edu.ifsp.prw3.avaliacao3.prw3_2026_1_api.mecanico;

import jakarta.validation.constraints.NotBlank;

public record DadosMecanico(
        @NotBlank
        String nome,

        int anosExperiencia
) {}
