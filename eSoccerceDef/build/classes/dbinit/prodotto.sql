CREATE TABLE IF NOT EXISTS prodotto ( 
`code` int NOT NULL PRIMARY KEY,
`urlimage` varchar(40) NOT NULL,
`nome` varchar(100) NOT NULL,
`marca` varchar(20) NOT NULL,
`descrizione` varchar(100) NOT NULL,
`prezzo` int default 0 NOT NULL,
`quantita` int NOT NULL,
`taglia` varchar(5),
`numero` int,
`dimensione` varchar(25),
`tipo` varchar(15)
);