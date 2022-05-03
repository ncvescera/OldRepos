<?php
$db_host = "localhost";
$db_user = "";
$db_pswd = "";
$db_name = "libri";
$list = array();
 
try
{
    $connection = new PDO("mysql:host=$db_host;dbname=$db_name", $db_user, $db_pswd);
    $connection-> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
}
catch (PDOException $e)
{
    echo $e;
}
 
 
