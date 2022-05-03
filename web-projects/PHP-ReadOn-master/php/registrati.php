<?php
require 'connect.php';

$user = $_POST['user'];
$email = $_POST['email'];
$password = $_POST["password"];
$nome = $_POST["nome"];
$cognome = $_POST["cognome"];

$query = "SELECT userid, email FROM users WHERE userid=\"$user\" AND email=\"$email\"";

foreach($connection->query($query) as $result){
    header("Location: ../registrati.html");
}

$query = "INSERT INTO users(email,userid,nome,cognome,pass) VALUES ('$email','$user','$nome','$cognome','$password')";

$connection->exec($query);

$connection = null;
header("Location: ../index.html");