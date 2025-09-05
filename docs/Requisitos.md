# Requisitos Funcionais – Rastreador de Pets (MVP)

## 1. Autenticação e Autorização

- **RF-01**: Usuário pode criar conta e fazer login (JWT).
- **RF-02**: Papéis: USER e ADMIN.
- **RF-03**: Implementar política de privacidade visível no app e consentimento de uso de dados.

## 2. Gestão de Assinaturas/Planos

- **RF-04**: Listar planos disponíveis.
- **RF-05**: Assinar plano (checkout simulado) e ver status da assinatura.
- **RF-06**: Permitir troca ou cancelamento do plano.

## 3. Pets e Dispositivos

- **RF-07**: CRUD de Pet (nome, espécie, foto).
- **RF-08**: Vincular dispositivo ao pet via serial + secret (pairing).
- **RF-09**: Mostrar status do dispositivo (online/offline, última comunicação).

## 4. Telemetria e Rastreamento

- **RF-10**: Receber telemetria do device via Firebase → Lambda → API `/ingest/telemetry`.
- **RF-11**: Visualizar posição atual do pet no mapa.
- **RF-12**: Exibir histórico de rota por período.
- **RF-13**: Atualização em tempo real (SSE/WebSocket).

## 5. Geofences e Alertas

- **RF-14**: Criar/editar geofences (polígono GeoJSON).
- **RF-15**: Gerar alertas ao entrar/sair de geofence.
- **RF-16**: Enviar notificações por e-mail/SNS (simulado).

## 6. Experiência do Usuário

- **RF-17**: Jornada: landing → cadastro → plano → vincular device → dashboard.
- **RF-18**: Dashboard com última localização, mapa, bateria e notificações.
- **RF-19**: Cadastro e edição de perfil do tutor (nome, contato, preferências).

# Requisitos Não Funcionais – Rastreador de Pets

## Segurança

- **RNF-01:** Todas as comunicações entre dispositivo, site e servidor devem usar TLS.
- **RNF-02:** Autenticação via JWT com expiração curta.
- **RNF-03:** Dados pessoais e de localização devem estar em conformidade com a LGPD.

## Desempenho

- **RNF-04:** Atualização de localização em tempo real ≤ 2 segundos ponta a ponta.
- **RNF-05:** O sistema deve suportar pelo menos 1.000 dispositivos simultâneos no MVP.
- **RNF-06:** Resposta da API ≤ 300 ms em condições normais.

## Escalabilidade e Disponibilidade

- **RNF-07:** Disponibilidade alvo de 99%, com tolerância a falhas de um nó.
- **RNF-08:** Banco de dados com índices em (device_id, timestamp) para consultas rápidas.

## Observabilidade

- **RNF-09:** Sistema deve ter logs estruturados e métricas expostas via `/health`.
- **RNF-10:** Alertas automáticos em caso de falha de atualização de telemetria > 5 min.

## Portabilidade e Deploy

- **RNF-11:** Deploy via Docker Compose (on-premises) e Kubernetes (SaaS).
- **RNF-12:** Deve rodar em múltiplos ambientes (Linux/Windows).

## Testes e Qualidade

- **RNF-13:** Testes unitários e de integração obrigatórios no CI/CD.

## Usabilidade

- **RNF-14:** O app deve ter interface responsiva (mobile-first).
- **RNF-15:** Atualização do mapa deve ser fluida, sem travamentos perceptíveis ao usuário.
