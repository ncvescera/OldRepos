<?php

require 'connect.php';

$query = "SELECT id FROM libri";

echo "<option>Scegli</option>";

foreach ($connection->query($query) as $elem){
    echo "<option value=\"$elem[0]\">$elem[0]</option>";
}

$connection = null;