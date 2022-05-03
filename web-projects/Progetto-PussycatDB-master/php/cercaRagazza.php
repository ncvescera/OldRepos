<?php
  include 'connect.php';
  include 'printRagazzaFunction.php';

  $str = $_GET['query'];
  $query = "SELECT * FROM ragazze WHERE nome LIKE '$str%' OR cognome LIKE '$str%' ORDER BY id ASC";

  printRagazza($connessione,$query);

  $connessione = null;

?>
