<?php
require 'connect.php';
session_start();

$autore = $_POST["autore"];
$titolo = $_POST["titolo"];
$editrice = $_POST["editrice"];
$id = $_POST["id"];


if(isset($_SESSION["user"])){
    $user = $_SESSION["user"];
    
    try {
        $query = "INSERT INTO libri (autore,titolo,casaeditrice,id,userid) VALUES ('$autore','$titolo','$editrice','$id','$user')";
        $connection->exec($query);
        $connection = null;
    
        echo "<b><font color=green>Libro aggiunto correttamente</font></b>";
    } catch (Exception $ex) {
        echo "<b><font color=red>Errore!</font></b>";
    }
    
}
 else {
     echo "<b><font color=red>Errore!</font></b>";
}

