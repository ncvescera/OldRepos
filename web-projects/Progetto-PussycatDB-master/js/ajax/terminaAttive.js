var id_ternima = 0;

function terminaAttive(id,azione) {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     $('#result').html(this.responseText);
    }
  };
  xhttp.open("GET", "/pussycat/php/terminaAttive.php?id="+id+"&azione="+azione, true);
  xhttp.send();
}

function setIdTermina(id){
  id_ternima = id;
}

function asd(){
  alert(id_ternima);
}
