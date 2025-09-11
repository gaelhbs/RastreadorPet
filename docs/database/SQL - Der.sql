CREATE DATABASE IF NOT EXISTS RastreadorPetsDBSENAI
DEFAULT CHARACTER SET utf8mb4 
COLLATE utf8mb4_general_ci;

USE RastreadorPetsDBSENAI;

CREATE TABLE clientes (
  cliente_id INT AUTO_INCREMENT PRIMARY KEY,
  cliente_nome_completo VARCHAR(255) NOT NULL,
  cliente_email VARCHAR(255) UNIQUE NOT NULL,
  cliente_senha VARCHAR(255) NOT NULL,
  cliente_telefone VARCHAR(20) NULL,
  cliente_cep VARCHAR(9) NULL,
  cliente_rua VARCHAR(255) NULL,
  cliente_numero VARCHAR(20) NULL,
  cliente_complemento VARCHAR(100) NULL,
  cliente_bairro VARCHAR(100) NULL,
  cliente_cidade VARCHAR(100) NULL,
  cliente_estado VARCHAR(2) NULL,
  cliente_data_cadastro TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  cliente_role ENUM('USER', 'ADMIN') NOT NULL DEFAULT 'USER',
  cliente_data_consentimento_privacidade TIMESTAMP NULL,
  cliente_preferencias JSON NULL
);

CREATE TABLE planos (
  plano_id INT AUTO_INCREMENT PRIMARY KEY,
  plano_nome VARCHAR(100) NOT NULL,
  plano_descricao TEXT NULL,
  plano_preco_mensal DECIMAL(10,2) NOT NULL
);

CREATE TABLE dispositivos (
  dispositivo_id INT AUTO_INCREMENT PRIMARY KEY,
  dispositivo_codigo_identificador VARCHAR(100) UNIQUE NOT NULL,
  dispositivo_modelo VARCHAR(100) NULL,
  dispositivo_status ENUM('Ativo', 'Inativo', 'Manutenção') NOT NULL,
  dispositivo_secret_hash VARCHAR(255) NOT NULL,
  dispositivo_ultima_comunicacao TIMESTAMP NULL
);

CREATE TABLE pets (
  pet_id INT AUTO_INCREMENT PRIMARY KEY,
  pet_nome VARCHAR(100) NOT NULL,
  pet_especie VARCHAR(50) NULL,
  pet_raca VARCHAR(100) NULL,
  pet_data_nascimento DATE NULL,
  pet_genero ENUM('Macho', 'Fêmea') NULL,
  pet_url_foto VARCHAR(255) NULL, 
  fk_cliente_id INT NOT NULL,
  fk_dispositivo_id INT UNIQUE NULL,
  
  FOREIGN KEY (fk_cliente_id) REFERENCES clientes(cliente_id)
    ON DELETE CASCADE ON UPDATE CASCADE,
    
  FOREIGN KEY (fk_dispositivo_id) REFERENCES dispositivos(dispositivo_id)
    ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE assinaturas (
  assinatura_id INT AUTO_INCREMENT PRIMARY KEY,
  assinatura_data_inicio DATE NOT NULL,
  assinatura_data_fim DATE NULL,
  assinatura_status ENUM('Ativa', 'Cancelada', 'Inadimplente') NOT NULL,
  fk_cliente_id INT NOT NULL,
  fk_plano_id INT NOT NULL,
  
  FOREIGN KEY (fk_cliente_id) REFERENCES clientes(cliente_id)
    ON DELETE RESTRICT ON UPDATE CASCADE,
    
  FOREIGN KEY (fk_plano_id) REFERENCES planos(plano_id)
    ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE formas_pagamento (
  forma_pagamento_id INT AUTO_INCREMENT PRIMARY KEY,
  forma_pagamento_tipo VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE recebimentos (
  recebimento_id INT AUTO_INCREMENT PRIMARY KEY,
  recebimento_valor_pago DECIMAL(10,2) NOT NULL,
  recebimento_data_pagamento DATETIME NOT NULL,
  recebimento_status_pagamento ENUM('Aprovado', 'Pendente', 'Recusado') NOT NULL,
  fk_cliente_id INT NOT NULL,
  fk_assinatura_id INT NOT NULL,
  fk_forma_pagamento_id INT NOT NULL,

  FOREIGN KEY (fk_cliente_id) REFERENCES clientes(cliente_id)
    ON DELETE RESTRICT ON UPDATE CASCADE,
    
  FOREIGN KEY (fk_assinatura_id) REFERENCES assinaturas(assinatura_id)
    ON DELETE NO ACTION ON UPDATE NO ACTION,

  FOREIGN KEY (fk_forma_pagamento_id) REFERENCES formas_pagamento(forma_pagamento_id)
    ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE localizacoes (
  localizacao_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  localizacao_latitude DECIMAL(10,8) NOT NULL,
  localizacao_longitude DECIMAL(11,8) NOT NULL,
  localizacao_data_hora TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  localizacao_nivel_bateria DECIMAL(5,2) NULL, 
  fk_dispositivo_id INT NOT NULL,

  FOREIGN KEY (fk_dispositivo_id) REFERENCES dispositivos(dispositivo_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE logs_sistema (
  log_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  log_data_hora TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  log_evento VARCHAR(100) NOT NULL,
  log_descricao TEXT NOT NULL,
  fk_cliente_id INT NULL,
  log_ip_origem VARCHAR(45) NULL,
  
  FOREIGN KEY (fk_cliente_id) REFERENCES clientes(cliente_id)
    ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE geofences (
  geofence_id INT AUTO_INCREMENT PRIMARY KEY,
  geofence_nome VARCHAR(100) NOT NULL,
  geofence_area JSON NOT NULL,
  geofence_ativa BOOLEAN NOT NULL DEFAULT TRUE,
  fk_cliente_id INT NOT NULL,
  
  FOREIGN KEY (fk_cliente_id) REFERENCES clientes(cliente_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE alertas (
  alerta_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  alerta_tipo ENUM('ENTRADA_GEOFENCE', 'SAIDA_GEOFENCE', 'BATERIA_BAIXA') NOT NULL,
  alerta_data_hora TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  alerta_lido BOOLEAN NOT NULL DEFAULT FALSE,
  fk_pet_id INT NOT NULL,
  fk_geofence_id INT NULL, 
  
  FOREIGN KEY (fk_pet_id) REFERENCES pets(pet_id)
    ON DELETE CASCADE ON UPDATE CASCADE,
    
  FOREIGN KEY (fk_geofence_id) REFERENCES geofences(geofence_id)
    ON DELETE SET NULL ON UPDATE CASCADE
);
