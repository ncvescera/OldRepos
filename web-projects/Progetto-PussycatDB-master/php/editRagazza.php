<?php
  include 'connect.php';

  $value = $_GET['value'];
  $id = $_GET['id'];

  $split = explode("_",$id); //estraggo i campi necessari per creare la query

  $campo = $split[0];
  $id_ragazza = $split[1];


  $query = "UPDATE ragazze SET $campo='$value' WHERE id=$id_ragazza";

  try {
    $connessione->exec($query);
    echo " <div class=\"alert alert-success alert-dismissable\">
    <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">×</a>
    <strong>Yee!</strong> Campo aggioranto con successo !
  </div>";
  } catch (Exception $e) {
    echo " <div class=\"alert alert-danger alert-dismissable\">
    <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">×</a>
    <strong>Ops!</strong> Qualcosa è andato storto :/
  </div>";
  } finally {
    $connessione = null;
  }

?>
