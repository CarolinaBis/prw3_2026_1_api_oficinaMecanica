package br.edu.ifsp.prw3.avaliacao3.prw3_2026_1_api.conserto;


import br.edu.ifsp.prw3.avaliacao3.prw3_2026_1_api.mecanico.DadosMecanico;
import br.edu.ifsp.prw3.avaliacao3.prw3_2026_1_api.veiculo.DadosVeiculo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroConserto(
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String dataEntrada,

        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String dataSaida,

        @Valid
        DadosMecanico mecanico,

        @Valid
        DadosVeiculo veiculo
) {}