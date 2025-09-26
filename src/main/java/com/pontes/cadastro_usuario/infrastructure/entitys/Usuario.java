package com.pontes.cadastro_usuario.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "usuario")
@Builder
@Entity

public class Usuario {
    @Id //Id da tabela
    @GeneratedValue(strategy = GenerationType.AUTO) //Gerador automatico de id
    private Integer id;

    @Column(name = "nome", unique = true)
    private String nome;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    private String cpf;
}
