function changeHot(id) {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     loadTableRagazze();
    }
  };
  xhttp.open("GET", "/pussycat/php/changeHot.php?id="+id, true);
  xhttp.send();
}
