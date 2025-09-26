package com.pontes.cadastro_usuario.infrastructure.repository;

import com.pontes.cadastro_usuario.infrastructure.entitys.Usuario;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.processing.Find;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional <Usuario> findByCpf(String cpf);

    @Transactional //Caso de erro não deixa apaga o CPF
    void deleteByCpf(String cpf);
}
