<html>
<head>
  <title>Cliente: <?php session_start(); echo $_SESSION['cognome'];?></title>
  <meta charset="utf-8">

  <!-- Bootstrap -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

  <script>
  function conferma(){
    var result = window.confirm("Confermare l'ordine ?");
    if(result){
      alert("Ordine effettuato con successo!");
      window.location.href = "../annulla.php"; //se conferma dovrebbe succedere qualcosa ma per ora ritorna alla home;
    }
    else {
      window.location.href = "../annulla.php";
    }
  }
  </script>
</head>
<body>

  <!--Navbar -->
  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="#">Cliente: <?php session_start(); echo $_SESSION['nome']." ".$_SESSION['cognome'];?></a>
      </div>
    </div>
  </nav>

  <div class="row">
    <div class="col-sm-4 col-sm-offset-4">
      <h1>Seleziona le pizze</h1>
      <?php
      session_start();

      $file = fopen("../pizze.dat","r") or die("Impossibile aprire il file");

      echo "<select style=\"width: 50%; height: 25%;\" name=\"pizze\" multiple>";
      while(!feof($file)){
        $line = fgets($file);
        if($line != null){
          echo "<option value=\"$line\">$line</option>";
        }
      }
      fclose($file);
      echo "</select>";
      ?>
      <br><br>
      <button class="btn btn-success" style="width: 25%;" onclick="conferma()">Conferma</button> <a href="../annulla.php"><button class="btn btn-warning" style="width: 25%;" >Annulla</button></a>
    </div>
  </div>
</body>
</html>
