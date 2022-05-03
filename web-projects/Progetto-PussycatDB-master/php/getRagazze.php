<?php
  include 'connect.php';
  include 'printRagazzaFunction.php';

  $query = "SELECT * FROM ragazze ORDER BY id ASC";

  printRagazza($connessione,$query);

  $connessione = null;
?>
