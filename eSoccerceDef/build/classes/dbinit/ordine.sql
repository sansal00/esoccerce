CREATE TABLE IF NOT EXISTS ordine (
  `id` int NOT NULL PRIMARY KEY,
  `totale` int NOT NULL,
  `numerocarta` varchar(16) NOT NULL,
  `cvc` int NOT NULL,
  `datascadenza` varchar(5) NOT NULL,
  `nomeintestatario` varchar(20) NOT NULL,
  `cognomeintestatario` varchar(20) NOT NULL,
  `dataordine` varchar(100) NOT NULL,
  `spedizione` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL
  );
