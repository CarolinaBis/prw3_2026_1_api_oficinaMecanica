package br.edu.ifsp.prw3.avaliacao3.prw3_2026_1_api.controller;

import br.edu.ifsp.prw3.avaliacao3.prw3_2026_1_api.usuario.Usuario;
import br.edu.ifsp.prw3.avaliacao3.prw3_2026_1_api.usuario.dadosAutenticacao;
import br.edu.ifsp.prw3.avaliacao3.prw3_2026_1_api.util.security.TokenJWT;
import br.edu.ifsp.prw3.avaliacao3.prw3_2026_1_api.util.security.TokenJWTService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    private final AuthenticationManager manager;
    private final TokenJWTService tokenService;

    public AutenticacaoController(AuthenticationManager manager, TokenJWTService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid dadosAutenticacao dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(token);
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenJWT(tokenJWT));
    }
}
