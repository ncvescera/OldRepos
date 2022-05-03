function select() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            $('#select').html(this.responseText);
        }
    };
    xhttp.open("GET", "./php/select.php", true);
    xhttp.send();
}

function printSelectTable() {
    var id = $("#select").val();
    
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            $('#secectTable').html(this.responseText);
        }
    };
    xhttp.open("GET", "./php/printSelectTable.php?id="+id, true);
    xhttp.send();
}