function cerca() {
    var autore = $("#cerca").val();
    
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            $('#cercaTabella').html(this.responseText);
        }
    };
    xhttp.open("GET", "./php/cerca.php?autore="+autore, true);
    xhttp.send();
}