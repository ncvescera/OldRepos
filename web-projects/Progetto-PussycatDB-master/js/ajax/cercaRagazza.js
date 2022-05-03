function cercaRagazza(){
  var query = $('#cerca').val();

  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     $('#container').html(this.responseText);
    }
  };
  xhttp.open("GET", "/pussycat/php/cercaRagazza.php?query="+query, true);
  xhttp.send();
}
