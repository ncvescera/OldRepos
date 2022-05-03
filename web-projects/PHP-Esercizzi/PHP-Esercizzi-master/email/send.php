<?php
	$name 		= $_GET['nome'];
	$surname 	= $_GET['cognome'];
	$email		= $_GET['email'];

	$message 	= "Link magico: http://volturnodaniele.altervista.org/ese_rosati/recive.php?name=$name&surname=$surname";

	if(mail($email, "Conferma", $message))
		echo "Mail inviata con successo!";
	else
		echo "C'e un problema ...";
?>
