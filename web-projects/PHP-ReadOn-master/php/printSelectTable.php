<?php

require 'connect.php';

$id = $_GET["id"];

$query = "SELECT autore,titolo,casaeditrice,userid FROM libri WHERE id = '$id'";

echo "<table class=\"table\">";
echo "<tr><th>Autore</th><th>Titolo</th><th>Casa Editrice</th><th>User</th></tr>";
foreach ($connection->query($query) as $elem){
    echo "<tr>";
    echo "<td>$elem[0]</td><td>$elem[1]</td><td>$elem[2]</td><td>$elem[3]</td></tr>";
}
echo "</table>";

$connection = null;

