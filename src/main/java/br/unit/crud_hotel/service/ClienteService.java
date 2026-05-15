package br.unit.crud_hotel.service;


import br.unit.crud_hotel.domain.Cliente;
import br.unit.crud_hotel.repository.ClienteRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;


    public void salvarCliente(Cliente cliente){

        if (cliente.getEmail() == null || cliente.getNome() == null || cliente.getSexo() == null || cliente.getNumnoites() <= 0 || cliente.getNumhospedes() <=0 ){

            throw new RuntimeException("Preencha todos os campos obrigatorios");

        }
        cliente.setDatachegada(LocalDateTime.now());

        clienteRepository.saveAndFlush(cliente);
    }

    public List<Cliente> clienteList(){

        return clienteRepository.findAll();
    }

    public void deletarCliente(String email){

        clienteRepository.deleteByEmail(email);
    }

    public void atualizarCliente(UUID id, Cliente cliente){

        Cliente clienteEntity = clienteRepository.findById(id).orElseThrow(
                () -> new RuntimeException("ID nao encontrado!")
        );

        Cliente clienteAtualizado = Cliente.builder()
                .id(cliente.getId())
                .nome(cliente.getNome() != null ? cliente.getNome() : clienteEntity.getNome())
                .email(cliente.getEmail() != null ? cliente.getEmail() : clienteEntity.getEmail())
                .sexo(cliente.getSexo() != null ? cliente.getSexo() : clienteEntity.getSexo())
                .numnoites(cliente.getNumnoites() <= 0 ? clienteEntity.getNumnoites(): cliente.getNumnoites())
                .numhospedes(cliente.getNumhospedes() <=0 ? clienteEntity.getNumhospedes() : cliente.getNumhospedes())
                .mensagem(cliente.getMensagem() != null ? cliente.getMensagem() : clienteEntity.getMensagem())
                .datachegada(clienteEntity.getDatachegada())
                .build();

        clienteRepository.saveAndFlush(clienteAtualizado);
    }





}
