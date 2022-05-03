function loadSoci() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     $('#table').html(this.responseText);
    }
  };
  xhttp.open("GET", "./php/getSoci.php", true);
  xhttp.send();
}

function countM(){
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     $("[id=M]").html(this.responseText);
    }
  };
  xhttp.open("GET", "./php/countM.php", true);
  xhttp.send();
}

function loadM(){
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     $('#table').html(this.responseText);
    }
  };
  xhttp.open("GET", "./php/getSociM.php", true);
  xhttp.send();
}

function countF(){
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     $("[id=F]").html(this.responseText);
    }
  };
  xhttp.open("GET", "./php/countF.php", true);
  xhttp.send();
}

function loadF(){
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     $('#table').html(this.responseText);
    }
  };
  xhttp.open("GET", "./php/getSociF.php", true);
  xhttp.send();
}
