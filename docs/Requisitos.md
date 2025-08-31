# Requisitos Não Funcionais – Rastreador de Pets

## Segurança
- **RF-01:** Todas as comunicações entre dispositivo, site e servidor devem usar TLS.
- **RF-02:** Autenticação via JWT com expiração curta.
- **RF-03:** Dados pessoais e de localização devem estar em conformidade com a LGPD.

## Desempenho
- **RF-04:** Atualização de localização em tempo real ≤ 2 segundos ponta a ponta.
- **RF-05:** O sistema deve suportar pelo menos 1.000 dispositivos simultâneos no MVP.
- **RF-06:** Resposta da API ≤ 300 ms em condições normais.

## Escalabilidade e Disponibilidade
- **RF-07:** Disponibilidade alvo de 99%, com tolerância a falhas de um nó.
- **RF-08:** Banco de dados com índices em (device_id, timestamp) para consultas rápidas.

## Observabilidade
- **RF-09:** Sistema deve ter logs estruturados e métricas expostas via `/health`.
- **RF-10:** Alertas automáticos em caso de falha de atualização de telemetria > 5 min.

## Portabilidade e Deploy
- **RF-11:** Deploy via Docker Compose (on-premises) e Kubernetes (SaaS).
- **RF-12:** Deve rodar em múltiplos ambientes (Linux/Windows).

## Testes e Qualidade
- **RF-13:** Testes unitários e de integração obrigatórios no CI/CD.

## Usabilidade
- **RF-14:** O app deve ter interface responsiva (mobile-first).
- **RF-15:** Atualização do mapa deve ser fluida, sem travamentos perceptíveis ao usuário.
