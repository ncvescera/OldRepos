<?php
  include 'credential.php';
  /*Instaurazione della connessione mediante i metodi messi a disposizione dalla
  * classe "PDO".
  */
  try {
    $connessione = new PDO("mysql:host=$host;dbname=$db", $user, $password);
    // set the PDO error mode to exception
    $connessione->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    //echo "Connected successfully";
  }
  catch(PDOException $e){
    /*Nel caso in cui venga lanciata un'eccezione, verrà restituito il messaggio
     * di errore corrispondente.
     */
    echo ("Connection failed: " . $e->getCode());
  }
?>
