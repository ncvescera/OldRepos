function send(){
  var ogg = $('#oggetto').val();
  var num = $('#quantita').val();

  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      $('#result').html(this.responseText);
      printTable();
    }
  };
  xhttp.open("GET", "./php/getData.php?oggetto="+ogg+"&num="+num, true);
  xhttp.send();
}

function printTable(){
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      $('#table').html(this.responseText);
    }
  };
  xhttp.open("GET", "./php/printTable.php", true);
  xhttp.send();
}
