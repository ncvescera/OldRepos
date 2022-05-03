<?php
  include 'Oggetto.php';

  $oggetto  = $_GET['oggetto'];
  $num      = $_GET['num'];

  session_start();

  if(isset($_SESSION['first']) && $_SESSION['first'] == true){
    array_push($_SESSION['array'],new Oggetto($oggetto,$num));
    echo "Oggetto aggiunto come priva volta";
    $_SESSION['first'] = false;
  }
  else{
    $obj = new Oggetto($oggetto,$num);
    $toAdd = true; //se l'oggetto non è già presente va aggiutno
    foreach ($_SESSION['array'] as $elem) {
      if($elem->getNome() == $obj->getNome()){
        $toAdd = false;
        $elem->sumVal($obj->getVal());
        echo "Oggetto sommato ad altro oggetto";
      }
    }
    if($toAdd){
      array_push($_SESSION['array'],$obj);
      echo "Oggetto aggiunto per mancanza di oggetti uguali";
    }
  }

?>
