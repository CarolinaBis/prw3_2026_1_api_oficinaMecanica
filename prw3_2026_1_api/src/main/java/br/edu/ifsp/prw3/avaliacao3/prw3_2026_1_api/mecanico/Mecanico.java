package br.edu.ifsp.prw3.avaliacao3.prw3_2026_1_api.mecanico;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome;
    private int anosExperiencia;

    public void atualizarInformacoes(String nome, Integer anosExperiencia) {
        if (nome != null) {
            this.nome = nome;
        }
        if (anosExperiencia != null) {
            this.anosExperiencia = anosExperiencia;
        }
    }
}
