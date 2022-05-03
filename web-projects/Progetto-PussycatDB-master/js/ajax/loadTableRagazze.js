function loadTableRagazze() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     $('#container').html(this.responseText);
    }
  };
  xhttp.open("GET", "/pussycat/php/getRagazze.php", true);
  xhttp.send();
}
