function getUSer() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            $('#user').html(this.responseText);
        }
    };
    xhttp.open("GET", "./php/getUser.php", true);
    xhttp.send();
}