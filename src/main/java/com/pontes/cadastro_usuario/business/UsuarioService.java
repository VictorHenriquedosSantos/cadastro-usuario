package com.pontes.cadastro_usuario.business;

import com.pontes.cadastro_usuario.infrastructure.entitys.Usuario;
import com.pontes.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario); //Salva e fecha o banco de dados
    }

    public Usuario buscarUsuarioPorCpf(String cpf){
        return repository.findByCpf(cpf).orElseThrow(
                () -> new RuntimeException("CPF não encontrado!")
        );
    }

    public void deletarUsuarioPorCpf(String cpf){
        repository.deleteByCpf(cpf);
    }

    public void atualizarUsuarioPorId(Integer id, Usuario usuario){
        Usuario usuarioEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado"));
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ?
                        usuario.getEmail() : usuarioEntity.getEmail())
                .cpf(usuario.getCpf() != null ?
                        usuario.getCpf() : usuarioEntity.getCpf())
                .nome(usuario.getNome() != null ?
                        usuario.getNome() : usuarioEntity.getNome())
                .id(usuario.getId())
                .build();

        repository.saveAndFlush(usuarioAtualizado);
    }
}
