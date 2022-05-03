<?php

require 'connect.php';

$id = $_GET["id"];

$query = "SELECT email FROM users WHERE userid in (SELECT userid FROM libri WHERE id = '$id')";

$email = "";

foreach ($connection->query($query) as $elem){
    $email = $elem[0];
}

if($email == ""){
    echo "<b><font color=red>Errore</font></b>";
}
else{
    $query = "SELECT autore,titolo,casaeditrice FROM libri WHERE id = '$id'";
    
    $emailTXT = "";
    foreach ($connection->query($query) as $elem){
        $emailTXT = "Autore: $elem[0]\n\r"
                . "Titolo: $elem[1]\n\r"
                . "Casa Editrice: $elem[2]\n\r";
    }
    
    $success = mail($email, "Libro", $emailTXT);
    
    if($success)
        echo "<b><font color=green>Email inviata!</font></b>";
    else
        echo "<b><font color=red>Errore</font></b>";
    
    $connection = null;
    
    
}