function addToAttive(id){
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     $('#queryResult').html(this.responseText);
    }
  };
  xhttp.open("GET", "/pussycat/php/addToAttive.php?id="+id, true);
  xhttp.send();
}
