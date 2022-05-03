<?php

  function somma($uno,$due){
    return ($uno+$due);
  }

  function sottrai($uno,$due){
    return ($uno-$due);
  }

  function moltiplica($uno,$due){
    return ($uno*$due);
  }

  function divisione($uno,$due){
    return ($uno/$due);
  }

  function quadrato($a){
    return (pow($a,2));
  }

  function radice($a){
    return (sqrt($a));
  }

  function fattoriale($num){
    $res = 1;
    for ($i=1;$i<=$num;$i++)
      $res=$res*$i;
    return $res;
  }

  function printTabella($uno,$due){
    echo "<table border=\"1\">";
    echo "<tr><th>Azione</th><th>Risultato</th></tr>";
    echo "<tr>";
    echo "<td>Somma</td><td>".somma($uno,$due)."</td></tr>";
    echo "<tr>";
    echo "<td>Sottrazione</td><td>".sottrai($uno,$due)."</td></tr>";
    echo "<tr>";
    echo "<td>Moltiplicazione</td><td>".moltiplica($uno,$due)."</td></tr>";
    echo "<tr>";
    echo "<td>Divisione</td><td>".divisione($uno,$due)."</td></tr>";
    echo "<tr>";
    echo "<td>Potenza</td><td>".quadrato($uno)." ".quadrato($due)."</td></tr>";
    echo "<tr>";
    echo "<td>Radice</td><td>".radice($uno)." ".radice($due)."</td></tr>";
    echo "<tr>";
    echo "<td>Fattoriale</td><td>".fattoriale($uno)." ".fattoriale($due)."</td></tr>";
    echo "</table>";
  }

  /*MAIN*/
  $uno = (int)$_GET['uno'];
  $due = (int)$_GET['due'];

  printTabella($uno,$due);

?>
