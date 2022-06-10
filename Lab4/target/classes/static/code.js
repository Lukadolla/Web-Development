function removePerson(id) {
    var xhr = new XMLHttpRequest();
    xhr.onload=deletePerson;
    xhr.open("GET", "/people/remove?id="+id);
    xhr.send();
}

function addPerson() {
    var record = {
        surname : document.getElementById("surname").value,
        firstname : document.getElementById("firstname").value,
    };

    var xhr = new XMLHttpRequest();
    xhr.onload=insertPerson;
    xhr.open("POST", "/people/add");
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify(record));
}

function deletePerson() {
    var id = this.responseText;

    var table = document.getElementById("people");
    var row = document.getElementById("row_" + id);
    table.deleteRow(row.rowIndex);
}

function insertPerson() {
    var record = JSON.parse(this.responseText);

    var table = document.getElementById("people");
    var rows = table.querySelectorAll("tr");
    var row = table.insertRow(rows.length-1);
    row.id="row_"+record.id;
    var surname_cell = row.insertCell(0);
    var firstname_cell = row.insertCell(1);
    var button_cell = row.insertCell(2);
    var button_cell_2 = row.insertCell(3);

    surname_cell.innerHTML=record.surname;
    firstname_cell.innerHTML=record.firstname;
    button_cell.innerHTML="<button onclick='removePerson("+record.id+")'>Remove</button>";
    button_cell_2.innerHTML="<button onclick='viewPerson("+record.id+")'>View</button>";

    document.getElementById("surname").value="";
    document.getElementById("firstname").value="";
    document.getElementById("surname").focus();
}

function viewPerson(id){
    var xhr = new XMLHttpRequest();
    xhr.onload=poop;
    xhr.open("GET", "/phone/"+id);
    xhr.send();
}

function poop(){
    document.getElementById("table2").innerHTML = this.responseText;
}