<?php
  include 'connect.php';

  $query = "SELECT * FROM attive ORDER BY inizio DESC, id_ragazza DESC";

  echo '<table class="table">
    <tr><th>Nome</th><th>Cognome</th><th>Inizio</th><th>Termina</th></tr>';
  foreach($connessione->query($query) as $record) {
    $query_ragazze = "SELECT nome,cognome FROM ragazze WHERE id = $record[0]";

    echo "<tr>";
    //questo foreach è un po brutto ma si potrebbe risolvere
    foreach($connessione->query($query_ragazze) as $row){
      echo "<td>$row[0]</td><td>$row[1]</td>";
    }
    echo "<td>$record[1]</td>";

    echo"<td>
    <div class=\"dropdown\">
    <button class=\"btn btn-danger btn-sm dropdown-toggle\" data-toggle=\"dropdown\">termina
    <span class=\"caret\"></span></button>
    <ul class=\"dropdown-menu\">
      <li><a href=\"#\" data-toggle=\"modal\" data-target=\"#goodendModal\" onclick=\"setIdTermina($record[0])\">Buon fine</a></li>
      <li><a href=\"#\" onclick=\"terminaAttive($record[0],\"bad\")\">Andata male</a></li>
    </ul>
    </div>
    </td>";
    echo"</tr>";
  }

  echo "</table>";
?>
