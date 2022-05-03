<html>
<head>
  <!-- Bootstrap -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
  <div class="row">
    <div class="col-sm-4 col-sm-offset-4">
      <?php
        $array = json_decode($_GET['dati']); //decodifica dei dati in JSON

        $file = fopen("../pizze.dat","w") or die("Impossibile creare il file");

        //scrittura dei dati sul file
        foreach ($array as $elem){
          fwrite($file,$elem);
        }
        fclose($file);

        session_destroy(); //distruzione della sessione

        echo "<h1>File scritto correttamente!</h1>";
        echo "<a href=\"../index.html\"><button class=\"btn btn-success\" style=\"width: 100%;\">Torna alla Home</button></a>";
      ?>
    </div>
  </div>
</body>
</html>
