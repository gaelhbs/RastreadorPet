package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.models.Cliente;
import com.senai.rastreadorpet.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteFacade {

    @Autowired
    private ClienteService clienteService;

    public Cliente criarNovoCliente(Cliente cliente) {
        return clienteService.salvar(cliente);
    }
}
