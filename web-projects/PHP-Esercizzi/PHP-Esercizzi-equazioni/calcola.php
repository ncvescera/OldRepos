<?php
  //ricava i coefficienti da una stringa
  function getCoefficienti($equazione){
    $toReturn = array();

    $quadrato = substr($equazione,0,strpos($equazione,"^")-1); //-1 per prendere solo il coefficiente
    $equazione = substr($equazione,strpos($equazione,"^")+2); //+2 per considerare anche l'elevatore a potenza
    $toReturn['a'] = (int)$quadrato; //aggiunta dell'elemento all'array associativo

    $x = substr($equazione,0,strpos($equazione,"x"));
    if($x != null){
      $equazione = substr($equazione, strpos($equazione,"x")+1);
      $toReturn['b'] = (int)$x;
    }
    else {
      $toReturn['b'] = null;
    }

    $numero = $equazione;
    $toReturn['c'] = (int)$numero;

    return $toReturn; //return array_assoc
  }

  //funzione per risolvere un quazione di secondo grado dati i suoi coefficienti
  function calcola($coefficienti){
    $toReturn = array();

    if($coefficienti['b'] == null){ //calcolo dell'eqazione se manca il coefficiente b
      $risultato = sqrt(($coefficienti['c']*-1)/$coefficienti['a']);
      array_push($toReturn,$risultato,($risultato*-1));

      return $toReturn; //retunr array
    }
    else if($coefficienti['c'] == null){ //calcolo dell'eqazione se manca il coefficiente c
      array_push($toReturn,0);

      $risultato = ($coefficienti['b']*-1)/$coefficienti['a'];
      array_push($toReturn,$risultato);

      return $toReturn; //return array
    }
    else { //calcolo di un quazione normale
      $delta = ($coefficienti['b']*$coefficienti['b']) - (4*$coefficienti['a']*$coefficienti['c']);
      $risultato1 = ( ($coefficienti['b']*-1) + (sqrt($delta)) ) / (2*$coefficienti['a']);
      $risultato2 = ( ($coefficienti['b']*-1) - (sqrt($delta)) ) / (2*$coefficienti['a']);

      array_push($toReturn,$risultato1,$risultato2);

      return $toReturn; //return array
    }
  }

  $equazione = $_GET['equazione'];

  $coefficienti = getCoefficienti($equazione); //ricava i coefficienti

  $risultato = calcola($coefficienti); //calcola il risultato

  echo "<h1>Il risultato e': </h1>";
  echo "x1 = $risultato[0]<br>";
  echo "x2 = $risultato[1]";
  
 ?>
