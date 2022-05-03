<?php
	function whatTypeIs($number){
		if((float)$number == 0){
			/*echo "A invalid number was insert!";
			die();*/
			return -1; //c'è un problema
		}

		$f_number = (float) $number;
		$i_number = (int) $number;

		if($f_number==$i_number) //se il numero float è uguale all'int allora è intero
			return "INT"; //intero
		else
			return "FLOAT"; //float
	}

	function getDivisiori($number){
		$number = (int) $number;

		echo "Divisori: ";

		for($i=1;$i<$number;$i++){
			if(($number % $i) == 0)
				echo "$i ";
		}
		echo "$number<br>"; //il numero è divisore di se stesso
	}

	$number = $_GET['number'];
	$type = whatTypeIs($number);

	if ($type == -1) {
		echo "A invalid number was insert!";
		die();
	}

	echo "$number is: $type<br>";
	if($type == "INT"){
			getDivisiori($number);
	}
?>
