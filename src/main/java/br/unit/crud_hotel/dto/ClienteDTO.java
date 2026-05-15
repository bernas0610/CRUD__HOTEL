package br.unit.crud_hotel.dto;

import java.time.LocalDateTime;

public record ClienteDTO(String email , String nome , String sexo , Integer numnoites , Integer numhospedes , String mensagem){
}
