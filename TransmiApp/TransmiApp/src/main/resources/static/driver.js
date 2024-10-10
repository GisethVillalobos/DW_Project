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
                    '<td><button type="button" class="btn btn-outline-secondary" onclick="updateDriver(' + object["idDriver"] + ')">Editar</button>';
                trHTML +=
                    '<button type="button" class="btn btn-outline-danger" onclick="deleteDriver(' + object["idDriver"] + ')">Borrar</button></td>';
                trHTML += "</tr>";
            }
            document.getElementById("driversTable").innerHTML = trHTML;
        }
    };
}
uploadDrivers();

function showDriverCreateBox() {
    Swal.fire({
        title: 'Crear nuevo conductor',
        html:
            '<input id="name" class="swal2-input" placeholder="Nombre">' +
            '<input id="identification" class="swal2-input" placeholder="Cédula">' +
            '<input id="phone" class="swal2-input" placeholder="Teléfono">' +
            '<input id="address" class="swal2-input" placeholder="Dirección">' +
            '<input id="assignments" class="swal2-input" placeholder="Asignaciones">',
        focusConfirm: false,
        preConfirm: () => {
            createDriver();
        }
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
            Swal.fire('Conductor creado correctamente');
            uploadDrivers(); // Actualizar la tabla
        }
    };
}

function updateDriver(idDriver) {
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/api/driver/update/" + idDriver);
    xhttp.send();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            const driver = JSON.parse(this.responseText);
            Swal.fire({
                title: 'Editar conductor',
                html:
                    '<input id="id" type="hidden" value="' + driver.idDriver + '">' +
                    '<input id="name" class="swal2-input" placeholder="Nombre" value="' + driver.name + '">' +
                    '<input id="identification" class="swal2-input" placeholder="Cédula" value="' + driver.identification + '">' +
                    '<input id="phone" class="swal2-input" placeholder="Teléfono" value="' + driver.phone + '">' +
                    '<input id="address" class="swal2-input" placeholder="Dirección" value="' + driver.address + '">' +
                    '<input id="assignments" class="swal2-input" placeholder="Asignaciones" value="' + driver.assignments + '">',
                focusConfirm: false,
                preConfirm: () => {
                    editDriver(driver.idDriver);
                }
            });
        }
    };
}

function editDriver(idDriver) {
    const name = document.getElementById("name").value;
    const identification = document.getElementById("identification").value;
    const phone = document.getElementById("phone").value;
    const address = document.getElementById("address").value;
    const assignments = document.getElementById("assignments").value;

    const xhttp = new XMLHttpRequest();
    xhttp.open("PUT", "http://localhost:8080/api/driver/update/" + idDriver);
    xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(
        JSON.stringify({
            idDriver: idDriver,
            name: name,
            identification: identification,
            phone: phone,
            address: address,
            assignments: assignments
        })
    );
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            Swal.fire('Conductor actualizado correctamente');
            uploadDrivers(); // Actualizar la tabla
        }
    };
}

function deleteDriver(idDriver) {
    const xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "http://localhost:8080/api/driver/delete/" + idDriver);
    xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send();
    xhttp.onreadystatechange = function () {
        if (this.status == 204) {
            Swal.fire('Conductor eliminado correctamente');
            uploadDrivers(); // Actualizar la tabla
        }
    };
}
