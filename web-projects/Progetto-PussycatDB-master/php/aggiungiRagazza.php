<?php
  include 'connect.php';

  $nome     = $_GET['nome'];
  $cognome  = $_GET['cognome'];
  $fb       = $_GET['fb'];
  $voto     = intval($_GET['voto']);

  $query = "INSERT INTO ragazze (nome,cognome,fb,voto) VALUES ('$nome','$cognome','$fb',$voto)";

  try{
    $connessione->exec($query);
    echo " <div class=\"alert alert-success alert-dismissable\">
    <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">×</a>
    <strong>Yee!</strong> Ragazza aggiunta !
    </div>";
  } catch(PDOException $e) {
    //ripristina il contatore della tabella dato che viene autoincrementato anche se non va a buon fine a query
    $result = $connessione->query("SELECT Count(*) FROM ragazze")->fetch(PDO::FETCH_BOTH);
    $number = $result[0] + 1;
    $connessione->exec("ALTER SEQUENCE ragazze_id_seq RESTART WITH $number");

    echo " <div class=\"alert alert-danger alert-dismissable\">
    <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">×</a>
    <strong>Ops!</strong> Qualcosa è andato storto :/
    </div>";
  } finally {
    $connessione = null;
  }
?>
