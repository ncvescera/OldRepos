<?php
  include 'connect.php';

  $id = $_GET['id'];

  $query = "SELECT hot FROM ragazze WHERE id = $id";

  foreach ($connessione->query($query) as $result) {
    if($result[0]) {
      $change = "UPDATE ragazze SET hot = FALSE where id = $id";
    }
    else {
      $change = "UPDATE ragazze SET hot = TRUE where id = $id";
    }
  }

  $connessione->exec($change);
  $connessione = null;
?>
