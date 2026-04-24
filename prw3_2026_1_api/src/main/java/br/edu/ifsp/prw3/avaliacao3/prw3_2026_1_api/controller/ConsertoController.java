package br.edu.ifsp.prw3.avaliacao3.prw3_2026_1_api.controller;

import br.edu.ifsp.prw3.avaliacao3.prw3_2026_1_api.conserto.*;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroConserto dados,
                                    UriComponentsBuilder uriBuilder) {
        var conserto = new Conserto(dados);
        repository.save(conserto);
        var uri = uriBuilder.path("/consertos/{id}").buildAndExpand(conserto.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoConserto(conserto));
    }

    @GetMapping
    public ResponseEntity listar(Pageable paginacao) {
        Page<DadosDetalhamentoConserto> pagina = repository.findAll(paginacao)
                .map(DadosDetalhamentoConserto::new);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("resumo")
    public ResponseEntity listarResumo() {
        List<DadosListagemConserto> lista = repository.findAllByAtivoTrue()
                .stream().map(DadosListagemConserto::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity getConsertoById(@PathVariable Long id) {
        Optional<Conserto> consertoOptional = repository.findById(id);
        if (consertoOptional.isPresent()) {
            return ResponseEntity.ok(new DadosDetalhamentoConserto(consertoOptional.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoConserto dados) {
        Conserto conserto = repository.getReferenceById(dados.id());
        conserto.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Conserto conserto = repository.getReferenceById(id);
        conserto.excluir();
        return ResponseEntity.noContent().build();
    }
}