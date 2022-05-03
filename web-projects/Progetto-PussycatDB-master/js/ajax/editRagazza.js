function editRagazza(id,value){
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      loadTableRagazze();
      $('#queryResult').html(this.responseText);
    }
  };
  xhttp.open("GET", "/pussycat/php/editRagazza.php?id="+id+"&value="+value, true);
  xhttp.send();
}
