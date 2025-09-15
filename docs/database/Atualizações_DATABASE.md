# Log de atualizações do Banco de Dados - Rastreador de Pets

Este documento resume as principais mudanças feitas no schema do banco de dados, alinhada com os requisitos do MVP.

---

### 1. Simplificação Inicial e Ajustes de Regras

No primeiro passo, limpei o modelo inicial para focar no essencial do MVP.

* **Tabela `funcionarios` Removida:** Foi removido a tabela `funcionarios` e todas as referências a ela. A gestão de funcionários não faz parte do escopo inicial e só adicionaria complexidade desnecessária agora.

* **Relacionamento Pet-Dispositivo (1 para 1):** Ajustei a lógica para que cada pet possa ter apenas um dispositivo. Para isso, movi a chave estrangeira para a tabela `pets` (`fk_dispositivo_id`) e adicionei uma restrição `UNIQUE`. Isso garante a regra de negócio diretamente no banco.

---

### 2. Expansão para Suportar as Funcionalidades

Depois da limpeza, adicionei as tabelas e colunas que faltavam para suportar os requisitos funcionais definidos.

#### Novas Tabelas

* **`geofences`:** Criei esta tabela para que os usuários possam desenhar e salvar suas cercas virtuais (RF-14). Ela armazena o nome, a área (usando GeoJSON) e a qual usuário pertence.
* **`alertas`:** Essencial para registrar os eventos de entrada/saída das geofences, bateria baixa, etc. (RF-15, RF-18). Ela conecta um pet a um evento, servindo como histórico de notificações.

#### Novas Colunas

Adicionei colunas específicas para atender a requisitos-chave:

* `cliente_role`: Para diferenciar `USER` de `ADMIN` (RF-02).
* `cliente_data_consentimento_privacidade`: Para registrar o aceite da política de privacidade, atendendo à LGPD (RF-03).
* `pet_url_foto`: Para permitir o upload de foto no cadastro do pet (RF-07).
* `dispositivo_secret_hash`: Para o pareamento seguro do dispositivo (RF-08).
* `dispositivo_ultima_comunicacao`: Para checar se o dispositivo está online/offline (RF-09).
* `localizacao_nivel_bateria`: Para mostrar o status da bateria no dashboard (RF-18).

---

### 3. Padronização Geral da Nomenclatura

Para finalizar, apliquei um padrão de nomenclatura em todo o banco, baseado nas melhores práticas. O objetivo é deixar o schema mais legível, consistente e menos propenso a erros em queries complexas.

As novas regras são:

* **Chaves Primárias (PK):** Sempre no formato `nome_tabela_singular_id` (ex: `cliente_id`).
* **Chaves Estrangeiras (FK):** Sempre com o prefixo `fk_` seguido do nome da PK que referenciam (ex: `fk_cliente_id`).
* **Colunas Comuns:** Sempre prefixadas com o nome singular da tabela (ex: `pet_nome`, `dispositivo_modelo`).

### Principais Decisões de Design

Algumas escolhas foram feitas para garantir a flexibilidade e escalabilidade do sistema:

* **Uso do tipo `JSON`:**
    * Em `cliente_preferencias` para permitir a adição de novas configurações no futuro sem alterar a estrutura da tabela.
    * Em `geofence_area` para armazenar o polígono no formato padrão GeoJSON, facilitando a integração com mapas.
