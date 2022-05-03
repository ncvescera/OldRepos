<?php
  include 'connect.php';

  $query = "SELECT Count(*) FROM `Archivio Soci` WHERE sesso='F'";

  foreach ($connessione->query($query) as $result) {
    echo "$result[0]";
  }

  $connessione = null;
?>
