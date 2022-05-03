<?php
  function printRagazza($connessione,$query){
    echo '<table class="table">';
    echo '<tr><th>Chat</th><th>ID</th><th>Nome</th><th>Cognome</th><th>Facebook</th><th>Voto</th><th>Attive</th><th>Hot</th></tr>';

    foreach ($connessione->query($query) as $record) {
      echo "<tr><td>
      <button class=\"btn btn-xs btn-default\" onclick=\"addToAttive($record[0])\">
        <span class=\"glyphicon glyphicon-plus\" aria-hidden=\"true\"></span>
      </button></td>
      <td id=\"tr_id_$record[0]\"><span id=\"id_$record[0]\" onmousedown=\"rmbPress(event,this.id)\">$record[0]</span></td>
      <td id=\"tr_nome_$record[0]\"><span id=\"nome_$record[0]\" onmousedown=\"rmbPress(event,this.id)\">$record[1]</span></td>
      <td id=\"tr_cognome_$record[0]\"><span id=\"cognome_$record[0]\" onmousedown=\"rmbPress(event,this.id)\">$record[2]</span></td>
      <td id=\"tr_fb_$record[0]\"><a href=\"$record[3]\" target=\"_blank\"><span id=\"fb_$record[0]\" onmousedown=\"rmbPress(event,this.id)\">$record[3]</span></a></td>
      <td id=\"tr_voto_$record[0]\"><span id=\"voto_$record[0]\" onmousedown=\"rmbPress(event,this.id)\">$record[4]</span></td>";

      echo "<td>";
      $queryCheck = "SELECT id_ragazza FROM attive WHERE id_ragazza = $record[0]";
      foreach ($connessione->query($queryCheck) as $elem){
        echo "<span class=\"glyphicon glyphicon-bookmark\"></span>";
      }
      echo "</td>";

      echo "<td onclick=\"changeHot($record[0])\" style=\"cursor: pointer;\">";
      if($record[5]){
        echo "<span class=\"glyphicon glyphicon-fire\"></span>";
      }
      echo "</td></tr>";
    }

    echo "</table>";
  }
?>
