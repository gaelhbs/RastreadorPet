# 📌 Delimitação do Escopo (MVP)

### ✅ Incluído

## **Backend (Spring Boot)**

1. Autenticação e autorização de usuários.
2. CRUD de pets e dispositivos.
3. Ingestão de telemetria recebida via AWS Lambda.
4. Associação usuário → pet → device.
5. Regras de negócio: geofence e alerta de bateria.
6. Exposição de APIs REST + WebSocket (tempo real).

## Frontend (React)

1. Cadastro e login de usuário.
2. Escolha de plano (simulado).
3. Fluxo de vinculação de pet + dispositivo.
4. Dashboard em mapa com rastreamento em tempo real.
5. Visualização de status da bateria e alertas de geofence.

## Dispositivo IoT (GPS real)

1. Coleta de latitude/longitude.
2. Leitura de status de bateria.
3. Envio de telemetria via Firebase.

## Integração AWS

1. IoT Core: recepção de telemetria.
2. Lambda: processamento de mensagens e envio para Backend.
3. RDS (MySQL): persistência de dados.
4. S3 (opcional): imagens/documentos.

### 🚫 Excluído

1. Integração com sistema de pagamento real (apenas simulado).
2. App mobile nativo.
3. Painéis analíticos e relatórios avançados.
4. Produção em escala de hardware industrial (usará protótipo IoT).

### 🎯 Critérios de Aceite

1. Usuário cadastrado escolhe um plano/adquire a coleira (simulado).
2. Usuário vincula dispositivo a um pet/coleira.
3. Dispositivo GPS envia telemetria real → Firebase → Backend → Frontend.
4. Dashboard mostra localização em tempo real no mapa.
5. Sistema dispara alerta de geofence quando o pet sai/entra da área definida.
