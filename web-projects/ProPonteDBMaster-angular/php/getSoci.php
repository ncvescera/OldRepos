<?php
  include 'connect.php';

  $query = "SELECT id, nome, cognome FROM `Archivio Soci` ORDER BY id asc";

  $statement=$connessione->prepare($query);
  $statement->execute();
  $results=$statement->fetchAll(PDO::FETCH_ASSOC);
  $json=json_encode($results);

  echo $json;
  
  $connessione = null;
?>
