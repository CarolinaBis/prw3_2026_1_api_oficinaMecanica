package br.edu.ifsp.prw3.avaliacao3.prw3_2026_1_api.conserto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoConserto(
        @NotNull
        Long id,

        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String dataSaida,

        String nomeMecanico,

        Integer anosExperiencia
) {}
