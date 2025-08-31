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
