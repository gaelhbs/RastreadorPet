CREATE DATABASE IF NOT EXISTS RastreadorPetsDB2 
DEFAULT CHARACTER SET utf8mb4 
COLLATE utf8mb4_general_ci;

USE RastreadorPetsDB2;

CREATE TABLE clientes (
  id_cliente INT AUTO_INCREMENT PRIMARY KEY,
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
  cliente_data_cadastro TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE planos (
  id_plano INT AUTO_INCREMENT PRIMARY KEY,
  plano_nome VARCHAR(100) NOT NULL,
  plano_descricao TEXT NULL,
  plano_preco_mensal DECIMAL(10,2) NOT NULL
);

CREATE TABLE pets (
  id_pet INT AUTO_INCREMENT PRIMARY KEY,
  pet_nome VARCHAR(100) NOT NULL,
  pet_especie VARCHAR(50) NULL,
  pet_raca VARCHAR(100) NULL,
  pet_data_nascimento DATE NULL,
  pet_genero ENUM('Macho', 'Fêmea') NULL,
  id_cliente INT NOT NULL,
  
  FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE dispositivos (
  id_dispositivo INT AUTO_INCREMENT PRIMARY KEY,
  dispositivo_codigo_identificador VARCHAR(100) UNIQUE NOT NULL,
  dispositivo_modelo VARCHAR(100) NULL,
  dispositivo_status ENUM('Ativo', 'Inativo', 'Manutenção') NOT NULL,
  id_pet INT UNIQUE NULL,
  
  FOREIGN KEY (id_pet) REFERENCES pets(id_pet)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);

CREATE TABLE assinaturas (
  id_assinatura INT AUTO_INCREMENT PRIMARY KEY,
  assinatura_data_inicio DATE NOT NULL,
  assinatura_data_fim DATE NULL,
  assinatura_status ENUM('Ativa', 'Cancelada', 'Inadimplente') NOT NULL,
  id_cliente INT NOT NULL,
  id_plano INT NOT NULL,
  
  FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
    
  FOREIGN KEY (id_plano) REFERENCES planos(id_plano)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);

CREATE TABLE formas_pagamento (
  id_forma_pagamento INT AUTO_INCREMENT PRIMARY KEY,
  forma_pagamento_tipo VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE funcionarios (
  id_funcionario INT AUTO_INCREMENT PRIMARY KEY,
  funcionario_nome VARCHAR(255) NOT NULL,
  funcionario_cargo VARCHAR(100) NULL,
  funcionario_status ENUM('Ativo', 'Inativo') NOT NULL DEFAULT 'Ativo',
  funcionario_data_admissao DATE NULL
);

CREATE TABLE recebimentos (
  id_recebimento INT AUTO_INCREMENT PRIMARY KEY,
  recebimento_valor_pago DECIMAL(10,2) NOT NULL,
  recebimento_data_pagamento DATETIME NOT NULL,
  recebimento_status_pagamento ENUM('Aprovado', 'Pendente', 'Recusado') NOT NULL,
  id_cliente INT NOT NULL,
  id_assinatura INT NOT NULL,
  id_forma_pagamento INT NOT NULL,
  id_funcionario INT NULL,

  FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
    
  FOREIGN KEY (id_assinatura) REFERENCES assinaturas(id_assinatura)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,

  FOREIGN KEY (id_forma_pagamento) REFERENCES formas_pagamento(id_forma_pagamento)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,

  FOREIGN KEY (id_funcionario) REFERENCES funcionarios(id_funcionario)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);

CREATE TABLE localizacoes (
  id_localizacao BIGINT AUTO_INCREMENT PRIMARY KEY,
  localizacao_latitude DECIMAL(10,8) NOT NULL,
  localizacao_longitude DECIMAL(11,8) NOT NULL,
  localizacao_data_hora TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  id_dispositivo INT NOT NULL,
  FOREIGN KEY (id_dispositivo) REFERENCES dispositivos(id_dispositivo)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE logs_sistema (
  id_log BIGINT AUTO_INCREMENT PRIMARY KEY,
  log_data_hora TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  log_evento VARCHAR(100) NOT NULL,
  log_descricao TEXT NOT NULL,
  id_cliente INT NULL,
  id_funcionario INT NULL,
  ip_origem VARCHAR(45) NULL,
  
  FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
    
  FOREIGN KEY (id_funcionario) REFERENCES funcionarios(id_funcionario)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);
