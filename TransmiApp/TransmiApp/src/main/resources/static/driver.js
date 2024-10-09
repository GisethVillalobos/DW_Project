function uploadDrivers() {
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/api/driver/all");
    xhttp.send();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
            var trHTML = "";
            const objects = JSON.parse(this.responseText);
            for (let object of objects) {
                trHTML += "<tr>";
                trHTML += "<td>" + object["idDriver"] + "</td>";
                trHTML += "<td>" + object["name"] + "</td>";
                trHTML += "<td>" + object["identification"] + "</td>";
                trHTML += "<td>" + object["phone"] + "</td>";
                trHTML += "<td>" + object["address"] + "</td>";
                trHTML += "<td>" + object["assignments"] + "</td>";
                trHTML +=
                    '<td><button type="button" class="btn btn-outline-secondary" onclick="updateDriver(' + object["id"] + ')">Editar</button>';
                trHTML +=
                    '<button type="button" class="btn btn-outline-danger" onclick="deleteDriver(' + object["id"] + ')">Borrar</button></td>';
                trHTML += "</tr>";
            }
            document.getElementById("driverTable").innerHTML = trHTML;
        }
    };
}
uploadDrivers();

function editDriver() {
    Swal.fire({
        title: "Editar Conductor",
        html:
            '<input id="id" type="hidden">' +
            '<input id="name" class="swal2-input"  placeholder="Name">' +
            '<input id="identification" class="swal2-input" placeholder="Identification">' +
            '<input id="phone" class="swal2-input"  placeholder="Phone">' +
            '<input id="address" class="swal2-input" placeholder="Address">' +
            '<input id="assignments" class="swal2-input" placeholder="Assignments">',
        focusConfirm: false,
        preConfirm: () => {
            createDriver();
        },
    });
}

function createDriver() {
    const name = document.getElementById("name").value;
    const identification = document.getElementById("identification").value;
    const phone = document.getElementById("phone").value;
    const address = document.getElementById("address").value;
    const assignments = document.getElementById("assignments").value;

    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8080/api/driver/create");
        xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(
        JSON.stringify({
            name: name,
            identification: identification,
            phone: phone,
            address: address,
            assignments: assignments
        })
    );
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            const objects = JSON.parse(this.responseText);
            Swal.fire(objects["message"]);
            uploadBuses();
        }
    };
}

function updateBus(id) {
    console.log(id);
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/api/bus/read/" + id );
        xhttp.send();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            const obj = JSON.parse(this.responseText);
            console.log(obj.idDriver);
            Swal.fire({
                title: "Editar Conductor",
                html:
                    '<input id="id" type="hidden" value=' +
                    obj.idDriver +
                    ">" +
                    '<input id="name" class="swal2-input" placeholder="name" value="' +
                    obj.name +
                    '">' +
                    '<input id="identification" class="swal2-input" placeholder="identification" value="' +
                    obj.identification +
                    '">' +
                    '<input id="phone" class="swal2-input" placeholder="phone" value="' +
                    obj.phone +
                    '">' +
                    '<input id="address" class="swal2-input" placeholder="address" value="' +
                    obj.address +
                    '">' +
                    '<input id="assignments" class="swal2-input" placeholder="Assignments" value="' +
                    obj.assignments +
                    '">',
                focusConfirm: false,
                preConfirm: () => {
                    editarConductor(obj.id);
                },
            });
        }
    };
}

function editarConductor(id) {
    const name = document.getElementById("name").value;
    const identification = document.getElementById("identification").value;
    const phone = document.getElementById("phone").value;
    const address = document.getElementById("address").value;
    const assignments = document.getElementById("assignments").value;

    const xhttp = new XMLHttpRequest();
    xhttp.open("PUT", "http://localhost:8080/api/driver/update/" + id );
        xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(
        JSON.stringify({
            idDriver: id,
            name: name,
            identification: identification,
            phone: phone,
            address: address,
            assignments: assignments
        })
    );
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            const objects = JSON.parse(this.responseText);
            Swal.fire(objects["message"]);
            uploadDrivers();
        }
    };
}
function deleteDriver(id) {
    const xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "http://localhost:8080/api/driver/delete/" + id );
        xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(
        JSON.stringify({
            id: id,
        })
    );
    xhttp.onreadystatechange = function () {
        if (this.status == 204) {
            Swal.fire("Conductor eliminado");
            uploadDrivers();
        }
    };
}



