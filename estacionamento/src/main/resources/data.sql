    
DROP TABLE IF EXISTS Estabelecimento;
 
CREATE TABLE Estabelecimento (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nome VARCHAR(250) NOT NULL,
  cnpj VARCHAR(250) NOT NULL,
  endereco VARCHAR(250) DEFAULT NULL,
  telefone VARCHAR(250) DEFAULT NULL,
  veiculos VARCHAR(250)  NULL,
  qt_vagas_motos int,
  qt_vagas_carros int
  
);
 
insert into Estabelecimento (nome, cnpj, telefone, qt_vagas_motos, qt_vagas_carros)
values('VagasMil', '12345646', '1354632', 2, 1);
