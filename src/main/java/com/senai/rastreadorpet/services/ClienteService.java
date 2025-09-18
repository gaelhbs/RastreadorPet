package com.senai.rastreadorpet.services;

import com.senai.rastreadorpet.models.Cliente;
import com.senai.rastreadorpet.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        // Futuramente, aqui entrarão as regras de negócio.
        return clienteRepository.save(cliente);
    }
}
