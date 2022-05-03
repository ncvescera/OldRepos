<?php

require 'connect.php';

$autore = $_GET["autore"];

$query = "SELECT id,titolo,casaeditrice,userid FROM libri WHERE autore = '$autore'";

echo "<table class=\"table\">";
echo "<tr><th>ID</th><th>Titolo</th><th>Casa Editrice</th><th>User</th></tr>";
foreach ($connection->query($query) as $elem){
    echo "<tr>";
    echo "<td>$elem[0]</td><td>$elem[1]</td><td>$elem[2]</td><td>$elem[3]</td></tr>";
}
echo "</table>";

$connection = null;
