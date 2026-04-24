package br.edu.ifsp.prw3.avaliacao3.prw3_2026_1_api.conserto;

import br.edu.ifsp.prw3.avaliacao3.prw3_2026_1_api.mecanico.Mecanico;
import br.edu.ifsp.prw3.avaliacao3.prw3_2026_1_api.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "consertos")
@Getter
@NoArgsConstructor
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dataEntrada;
    private String dataSaida;

    @Embedded
    private Mecanico mecanico;

    @Embedded
    private Veiculo veiculo;

    private Boolean ativo;

    public Conserto(DadosCadastroConserto dados) {
        this.dataEntrada = dados.dataEntrada();
        this.dataSaida = dados.dataSaida();
        this.mecanico = new Mecanico(dados.mecanico().nome(), dados.mecanico().anosExperiencia());
        this.veiculo = new Veiculo(
                dados.veiculo().marca(),
                dados.veiculo().modelo(),
                dados.veiculo().ano(),
                dados.veiculo().cor()
        );
        this.ativo = true;
    }

    public void excluir() {
        this.ativo = false;
    }

    public void atualizarInformacoes(DadosAtualizacaoConserto dados) {
        if (dados.dataSaida() != null) {
            this.dataSaida = dados.dataSaida();
        }
        this.mecanico.atualizarInformacoes(dados.nomeMecanico(), dados.anosExperiencia());
    }
}
