<?php
  include 'connect.php';

  $id = $_GET['id'];
  $azione = $_GET['azione'];

  if($azione == "good"){
    $query = "SELECT * FROM attive WHERE id_ragazza = $id";

    foreach ($connessione->query($query) as $row) {
      $connessione->exec("INSERT INTO goodend"); /*DA FINIRE */
    }
  }
?>
