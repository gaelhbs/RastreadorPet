package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.dto.DeviceDataIngestDTO;
import com.senai.rastreadorpet.models.LocationHistoryModel;
import com.senai.rastreadorpet.repositories.LocationHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

import static com.senai.rastreadorpet.mappers.LocationHistoryMapper.LOCATION_HISTORY_MAPPER;

@Service
@RequiredArgsConstructor
public class IngestionApplication {

    private final LocationHistoryRepository locationHistoryRepository;

    @Transactional
    public void processIngestedData(DeviceDataIngestDTO data) {

        if (data == null || data.getHistoricLocations() == null || data.getHistoricLocations().isEmpty()) {
            System.out.println("Dados de ingestão vazios. Nenhum histórico para processar.");
            return;
        }

        int deviceId = data.getDeviceId();

        List<LocationHistoryModel> historyModels =
                data.getHistoricLocations().stream()
                        .map(dto -> LOCATION_HISTORY_MAPPER.toEntityWithDeviceId(dto, deviceId))
                        .filter(model -> model.getDateTime() != null)
                        .collect(Collectors.toList());


        if (!historyModels.isEmpty()) {
            locationHistoryRepository.saveAll(historyModels);
            System.out.println("SUCESSO: " + historyModels.size() + " registros de histórico salvos no Aurora para o Dispositivo ID: " + deviceId);
        } else {
            System.out.println("AVISO: Todos os pontos foram considerados inválidos no mapeamento.");
        }

        // 4. (Opcional) Atualizar o estado atual do dispositivo
        // Se o DTO também contiver a localização atual, você chamaria um serviço aqui:
        // deviceService.updateCurrentLocationState(data.getDeviceId(), data.getCurrentLocationDTO());
    }


    /**
     * Converte um Unix Timestamp (Long) para um LocalDateTime.
     * Assume que o timestamp está em SEGUNDOS.
     * @param unixTimestamp Long representando o tempo desde a época Unix.
     * @return LocalDateTime correspondente.
     */
    private LocalDateTime convertUnixTimestampToLocalDateTime(Long unixTimestamp) {
        // Por padrão, Firebase e muitos sistemas usam MILISSEGUNDOS.
        // Adapte o código conforme o que o seu Firebase realmente envia.

        // Se estiver em MILISSEGUNDOS:
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(unixTimestamp), ZoneOffset.UTC);

        // Se estiver em SEGUNDOS, use:
        // return LocalDateTime.ofInstant(Instant.ofEpochSecond(unixTimestamp), ZoneOffset.UTC);
    }
}
