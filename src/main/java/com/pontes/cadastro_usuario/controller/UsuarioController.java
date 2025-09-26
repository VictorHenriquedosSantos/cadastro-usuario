package com.pontes.cadastro_usuario.controller;

import com.pontes.cadastro_usuario.business.UsuarioService;
import com.pontes.cadastro_usuario.infrastructure.entitys.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario){
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorCpf(@RequestParam String cpf){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorCpf(cpf));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorCpf(@RequestParam String cpf){
        usuarioService.deletarUsuarioPorCpf(cpf);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId(@RequestParam Integer id,
                                                      @RequestBody Usuario usuario) {
        usuarioService.atualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();

    }
}

