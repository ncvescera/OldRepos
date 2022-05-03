<?php
  include 'Oggetto.php';
  session_start();

  getMax();

  echo "<table class=\"table\">";
  echo "<tr><th>Nome</th><th>Quantità</th></tr>";

  foreach ($_SESSION['array'] as $elem) {
    echo "<tr><td>{$elem->getNome()}</td><td>{$elem->getVal()}</td></tr>";
  }

  echo "</table>";

  function getMax(){
    $array  = $_SESSION['array'];
    $max    = $array[0];

    foreach ($array as $elem) {
      if($elem->getVal() > $max->getVal()){
        $max = $elem;
      }
    }

    echo "Il maggiore è: <b>{$max->getNome()}</b> per numero di elementi <b>{$max->getVal()}</b>";
  }
?>
