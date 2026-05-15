package br.unit.crud_hotel.controller;


import br.unit.crud_hotel.domain.Cliente;
import br.unit.crud_hotel.dto.ClienteDTO;
import br.unit.crud_hotel.repository.ClienteRepository;
import br.unit.crud_hotel.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    private final ClienteService clienteService;


    @PostMapping
    public ResponseEntity<Cliente> reservarQuarto(@RequestBody ClienteDTO clienteDTO){

        Cliente cliente = Cliente.builder()
                .email(clienteDTO.email())
                .nome(clienteDTO.nome())
                .sexo(clienteDTO.sexo())
                .numhospedes(clienteDTO.numhospedes())
                .numnoites(clienteDTO.numnoites())
                .mensagem(clienteDTO.mensagem())
                .build();

        clienteService.salvarCliente(cliente);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarCliente(@RequestParam String email){

        var cliente = clienteService.clienteList();

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping
    public ResponseEntity<String> deletarCliente(@RequestParam String email){

        clienteService.deletarCliente(email);

        return ResponseEntity.ok("CLIENTE DELETADO!");
    }

    @PutMapping
    public ResponseEntity<String> atualizarCliente (@RequestParam UUID id , @RequestBody ClienteDTO clienteDTO){

        Cliente cliente = Cliente.builder()
                .id(id)
                .nome(clienteDTO.nome())
                .email(clienteDTO.email())
                .sexo(clienteDTO.sexo())
                .numnoites(clienteDTO.numnoites() != null ? clienteDTO.numnoites() : 0)
                .numhospedes(clienteDTO.numhospedes() != null ? clienteDTO.numhospedes() : 0)
                .mensagem(clienteDTO.mensagem())
                .build();

        clienteService.atualizarCliente(id , cliente);

        return ResponseEntity.ok("CLIENTE ATUALIZADO!");
    }

}
