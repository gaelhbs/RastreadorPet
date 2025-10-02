package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.entities.AssinaaturaEntity;
import com.senai.rastreadorpet.facade.AssinaturaFacade;
import com.senai.rastreadorpet.models.AssinaturaModel;
import com.senai.rastreadorpet.repositories.AssinaturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssinaturaApplication{

    private final AssinaturaRepository repository;

    private AssinaaturaEntity toEntity(AssinaturaModel model) {
        return new AssinaturaFacade(
                model.getId(),
                model.getTipoPlano(),
                model.getValor(),
                model.getDataInicio(),
                model.getDataFim()
        );
    }

    private AssinaturaModel toModel(AssinaaturaEntity entity) {
        return new AssinaturaModel(
                entity.getId(),
                entity.getTipoPlano(),
                entity.getValor(),
                entity.getDataInicio(),
                entity.getDataFim()
        );  
    }

    public AssinaturaModel create(AssinaturaModel model) {
        AssinaturaModel saved = repository.save(toEntity(model));
        return toModel((AssinaaturaEntity)  saved);
    }

    public List<AssinaturaModel> findAll() {
        return repository.findAll().stream().map(this::toModel).collect(Collectors.toList());
    }

    public AssinaturaModel findById(Long id) {
        return repository.findById(id).map(this::toModel).orElse(null);
    }

    public AssinaturaModel update(Long id, AssinaturaModel model) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setTipoPlano(model.getTipoPlano());
                    existing.setValor(model.getValor());
                    existing.setDataInicio(model.getDataInicio());
                    existing.setDataFim(model.getDataFim());
                    return toModel(repository.save(existing));
                }).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

