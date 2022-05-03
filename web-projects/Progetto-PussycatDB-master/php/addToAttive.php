<?php
  include 'connect.php';

  $id_ragazza = $_GET['id'];
  $data = date("Y-m-d");

  $query = "INSERT INTO attive (id_ragazza,inizio) VALUES ($id_ragazza,'$data')";

  try{
    $connessione->exec($query);
    echo " <div class=\"alert alert-success alert-dismissable\">
    <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">×</a>
    <strong>Yee!</strong> Operazione effettuata !
  </div>";
  } catch(PDOException $e){
    echo " <div class=\"alert alert-danger alert-dismissable\">
    <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">×</a>
    <strong>Ops!</strong> Probabilmente questa ragazza è già nella lista :/
  </div>";
  } finally{
    $connessione = null;
  }

?>
