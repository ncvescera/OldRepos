<?php
  include 'connect.php';

  $query = "SELECT id, nome, cognome FROM `Archivio Soci` WHERE sesso='F' ORDER BY id asc";

  echo "<table class=\"table\">";
  echo "<tr><th>ID</th><th>Nome</th><th>Cognome</th></tr>";
  foreach($connessione->query($query) as $row){
    echo "<tr><td>$row[0]</td><td>$row[1]</td><td>$row[2]</td></tr>";
  }
  echo "</table>";

  $connessione = null;
?>
