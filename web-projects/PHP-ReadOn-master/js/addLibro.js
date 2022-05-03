function addLibro() {
    var titolo = $("#titolo").val();
    var autore = $("#autore").val();
    var editrice = $("#editrice").val();
    var id = $("#id").val();
    
    var data = "titolo="+titolo+"&autore="+autore+"&editrice="+editrice+"&id="+id ;
    
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            $('#addresult').html(this.responseText);
        }
    };
    xhttp.open("POST", "./php/aggiungiLibro.php", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send(data);
}