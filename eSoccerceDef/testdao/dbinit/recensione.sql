 CREATE TABLE IF NOT EXISTS recensione (
  numero int NOT NULL PRIMARY KEY,
  nomeprodotto varchar(100) NOT NULL,
  descrizione varchar(300) NOT NULL,
  stelle int NOT NULL,
  email varchar(50) NOT NULL
  );