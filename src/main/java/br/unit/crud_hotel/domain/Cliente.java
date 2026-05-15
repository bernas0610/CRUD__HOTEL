package br.unit.crud_hotel.domain;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "clientes")
@Entity(name = "Cliente")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "email" , unique = true , nullable = false)
    private String email;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "sexo" , nullable = false)
    private String sexo;

    @Column(name = "numero_noites", nullable = false)
    private int numnoites;

    @Column(name = "numero_hospedes", nullable = false)
    private int numhospedes;

    @Column(name = "mensagem" , nullable = true)
    private String mensagem;

    @Column(name = "data_chegada")
    private LocalDateTime datachegada;




}
