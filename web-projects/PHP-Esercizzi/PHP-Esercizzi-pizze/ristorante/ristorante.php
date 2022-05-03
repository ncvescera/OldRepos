<html>
<head>
  <title>Ristorante</title>
  <meta charset="utf-8">

  <!--Bootrsap -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

  <script>
  var pizze = new Array(); //array che conterrà le pizze selezionate

  //funzione per aggiungere un elemento all'array
  function add(valore){
    pizze.push(valore);
  }

  //funzione per rimuovere un elemento dall'array
  function remove(valore){
    pizze.splice(pizze.indexOf(valore),1);
  }

  //funzione per scegliere se eliminare o aggiungere un elemento
  function change(value){
    //se l'elemento non esiste viene aggiunto
    if(pizze.indexOf(value) == -1){
      add(value);
    }
    else {
      remove(value);
    }
    //alert(pizze);
  }

  //converte l'array in JSON per poi passarlo a php
  function send(){
    window.location.href = "elabora.php?dati="+JSON.stringify(pizze);
  }
  </script>

</head>
<body>
  <!--Navbar -->
  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="#">Ristorante di: <?php session_start(); echo $_SESSION['nome']." ".$_SESSION['cognome'];?></a>
      </div>
    </div>
  </nav>

  <div class="row">
    <div class="col-sm-4 col-sm-offset-4">
      <h1>Seleziona le pizze</h1>
      <?php
      session_start();

      $file = fopen("data.dat","r") or die("File inesistente!"); //apertura del file con le pizze

      //lettura del file e creazione delle checkbox
      $i = 0;
      while(!feof($file)){
        $line = fgets($file);
        if($line != null){
          echo '<div class="checkbox">';
          echo '<label><input type="checkbox"'."name=\"$i\" value=\"$line\" onchange=\"change(this.value)\">$line</label>";
          echo "</div>";
          $i++;
        }
      }
      fclose($file);
      ?>
      <br>
      <button class="btn btn-success" style="width: 25%;" type="submit" onclick="send()">Invia</button> <a href="../annulla.php"><button class="btn btn-warning" style="width: 25%;" type="submit">annulla</button></a>
    </div>
  </div>
</body>
</html>
