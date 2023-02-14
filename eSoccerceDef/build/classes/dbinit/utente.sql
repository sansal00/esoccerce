CREATE TABLE IF NOT EXISTS utente (
  `email` varchar(50) NOT NULL PRIMARY KEY,
  `password` varchar(15) NOT NULL,
  `nome` varchar(15) NOT NULL,
  `cognome` varchar(15) NOT NULL,
  `indirizzo` varchar(50) NOT NULL,
  `citta` varchar(25) NOT NULL
  );