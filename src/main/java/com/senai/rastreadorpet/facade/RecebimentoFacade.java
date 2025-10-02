package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.RecebimentoApplication;
import com.senai.rastreadorpet.entities.RecebimentoEntity;
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

    private RecebimentoEntity toEntity(RecebimentoModel model) {
        if (model == null) return null;
        return new RecebimentoEntity(
                model.getId(),
                model.getValor(),
                model.getStatus(),
                model.getDataPagamento()
        );
    }

    private RecebimentoModel toModel(RecebimentoEntity entity) {
        if (entity == null) return null;
        return new RecebimentoModel(
                entity.getId(),
                entity.getValor(),
                entity.getStatus(),
                entity.getDataPagamento()
        );
    }

    public RecebimentoModel create(RecebimentoModel model) {
        RecebimentoEntity salvo = recebimentoApplication.salvar(toEntity(model));
        return toModel(salvo);
    }

    public List<RecebimentoModel> findAll() {
        return recebimentoApplication.listarTodos()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public RecebimentoModel findById(int id) {
        Optional<RecebimentoEntity> entity = recebimentoApplication.buscarPorId((long) id);
        return entity.map(this::toModel).orElse(null);
    }

    public RecebimentoModel update(int id, RecebimentoModel model) {
        Optional<RecebimentoEntity> atualizado = recebimentoApplication.buscarPorId((long) id)
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
