function aggiungiRagazza(){

  var nome     = $('#nome').val();
  var cognome  = $('#cognome').val();
  var fb       = $('#fb').val();
  var voto     = $('#voto').val();

  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      loadTableRagazze();
      $('#queryResult').html(this.responseText);
    }
  };
  xhttp.open("GET", "/pussycat/php/aggiungiRagazza.php?nome="+nome+"&cognome="+cognome+"&fb="+fb+"&voto="+voto, true);
  xhttp.send();
}
