package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.entities.Recebimento;
import com.senai.rastreadorpet.repositories.RecebimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecebimentoApplication {

    private final RecebimentoRepository recebimentoRepository;

    public Recebimento salvar(Recebimento recebimento) {
        return recebimentoRepository.save(recebimento);
    }

    public Optional<Recebimento> buscarPorId(Long id) {
        return recebimentoRepository.findById(id);
    }

    public List<Recebimento> listarTodos() {
        return recebimentoRepository.findAll();
    }

    public void excluir(Long id) {
        recebimentoRepository.deleteById(id);
    }
}
