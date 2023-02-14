CREATE TABLE IF NOT EXISTS ordinedettaglio (
  `code` int NOT NULL,
  `urlimage` varchar(40) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `marca` varchar(20) NOT NULL,
  `descrizione` varchar(100) NOT NULL,
  `prezzo` int NOT NULL DEFAULT '0',
  `quantitaacquistata` int NOT NULL,
  `taglia` varchar(5),
  `numero` int,
  `dimensione` varchar(25),
  `tipo` varchar(15),
  `id` int NOT NULL,
  PRIMARY KEY (`code`, `id`)
  );
  