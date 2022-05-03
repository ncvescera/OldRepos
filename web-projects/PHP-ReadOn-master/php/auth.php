<?php

require 'connect.php';

$user = $_POST["email"];
$password = $_POST["password"];

$query = "SELECT userid,pass FROM users WHERE userid=\"$user\" AND pass=\"$password\"";

$ok = false;
foreach($connection->query($query) as $result){
    echo "GOOD!";
    $ok = true;
}

$connection = null;

if($ok){
    session_start();
    $_SESSION["user"] = $user;
    header("Location: ../home.html");
}
else{
    header("Location: ../index.html");
}



