package br.edu.ifsp.prw3.avaliacao3.prw3_2026_1_api.mecanico;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome;
    private String experiencia;

    public Mecanico(DadosMecanico dados){
        this.nome = dados.nome();
        this.experiencia = dados.anosExperiencia();
    }

    public void atualizarInformacoes(DadosMecanico dadosMecanico) {
        if (dadosMecanico.nome() != null){
            this.nome = dadosMecanico.nome();
        }

        if (dadosMecanico.anosExperiencia() != null){
            this.experiencia = dadosMecanico.anosExperiencia();
        }
    }
}