package br.edu.ifsp.prw3.avaliacao3.prw3_2026_1_api.conserto;

import br.edu.ifsp.prw3.avaliacao3.prw3_2026_1_api.mecanico.Mecanico;
import br.edu.ifsp.prw3.avaliacao3.prw3_2026_1_api.veiculo.Veiculo;

public record DadosDetalhamentoConserto(
        Long id,
        String dataEntrada,
        String dataSaida,
        Boolean ativo,
        Mecanico mecanico,
        Veiculo veiculo
) {
    public DadosDetalhamentoConserto(Conserto conserto) {
        this(
                conserto.getId(),
                conserto.getDataEntrada(),
                conserto.getDataSaida(),
                conserto.getAtivo(),
                conserto.getMecanico(),
                conserto.getVeiculo()
        );
    }
}
