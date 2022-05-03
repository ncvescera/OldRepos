function email() {
    var id = $("#email").val();
    
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            $('#emailStato').html(this.responseText);
        }
    };
    xhttp.open("GET", "./php/email.php?id="+id, true);
    xhttp.send();
}