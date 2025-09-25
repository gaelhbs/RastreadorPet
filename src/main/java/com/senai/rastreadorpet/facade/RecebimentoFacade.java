package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.RecebimentoApplication;
import com.senai.rastreadorpet.entities.Recebimento;
import com.senai.rastreadorpet.models.RecebimentoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RecebimentoFacade {

    private final RecebimentoApplication recebimentoApplication;

    private Recebimento toEntity(RecebimentoModel model) {
        if (model == null) return null;
        return new Recebimento(
                model.getId(),
                model.getValor(),
                model.getStatus(),
                model.getDataPagamento()
        );
    }

    private RecebimentoModel toModel(Recebimento entity) {
        if (entity == null) return null;
        return new RecebimentoModel(
                entity.getId(),
                entity.getValor(),
                entity.getStatus(),
                entity.getDataPagamento()
        );
    }

    public RecebimentoModel create(RecebimentoModel model) {
        Recebimento salvo = recebimentoApplication.salvar(toEntity(model));
        return toModel(salvo);
    }

    public List<RecebimentoModel> findAll() {
        return recebimentoApplication.listarTodos()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public RecebimentoModel findById(int id) {
        Optional<Recebimento> entity = recebimentoApplication.buscarPorId((long) id);
        return entity.map(this::toModel).orElse(null);
    }

    public RecebimentoModel update(int id, RecebimentoModel model) {
        Optional<Recebimento> atualizado = recebimentoApplication.buscarPorId((long) id)
                .map(existente -> {
                    existente.setValor(model.getValor());
                    existente.setStatus(model.getStatus());
                    existente.setDataPagamento(model.getDataPagamento());
                    return recebimentoApplication.salvar(existente);
                });
        return atualizado.map(this::toModel).orElse(null);
    }

    public void delete(int id) {
        recebimentoApplication.excluir((long) id);
    }
}
