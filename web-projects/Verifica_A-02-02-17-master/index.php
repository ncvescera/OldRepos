<!DOCTYPE html>
<?php
  session_start();
  $array = array();

  $_SESSION['first'] = true;
  $_SESSION['array'] = $array;
?>
<html>
  <head>
    <meta charset="utf-8">
    <title>Form</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Chiamate AJAX -->
    <script src="./js/ajax.js"></script>

  </head>
  <body>
    <div class="row">
      <div class="col-md-6 col-md-offset-3">
        <h1>Form</h1>
        <p>Compila il form</p>
        <div class="form-inline">
          <label>Oggetto</label> <input type="text" id="oggetto" class="form-control">
          <label>Quantità</label> <input type="number" id="quantita" class="form-control">
          <button onclick="send()" class="btn btn-success">invia</button>
        </div>
        <br>
        <div id="result"></div>
      </div>
    </div>

    <br><br>

    <div class="row">
      <div class="col-md-8 col-md-offset-2">
          <div id="table"></div>
      </div>
    </div>
  </body>
</html>
