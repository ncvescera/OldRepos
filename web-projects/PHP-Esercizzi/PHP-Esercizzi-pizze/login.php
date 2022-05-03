<?php
    session_start(); //avvio della sessione

    //inizializzazione delle variabili di sessione
    $_SESSION['nome']     = $_POST['nome'];
    $_SESSION['cognome']  = $_POST['cognome'];
    $_SESSION['tipo']     = $_POST['tipo'];

    //scelta della pagina da caricare
    if ($_SESSION['tipo'] == "cliente") {
      header("Location:cliente/cliente.php");
    }
    else {
      header("Location:ristorante/ristorante.php");
    }


?>
