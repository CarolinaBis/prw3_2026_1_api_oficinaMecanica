package br.edu.ifsp.prw3.avaliacao3.prw3_2026_1_api.conserto;

public record DadosListagemConserto(
        Long id,
        String dataEntrada,
        String dataSaida,
        String nomeMecanico,
        String marcaVeiculo,
        String modeloVeiculo
) {
    public DadosListagemConserto(Conserto conserto) {
        this(
                conserto.getId(),
                conserto.getDataEntrada(),
                conserto.getDataSaida(),
                conserto.getMecanico().getNome(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo()
        );
    }
}