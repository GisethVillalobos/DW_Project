function uploadRoutes() {
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/api/route/all");
    xhttp.send();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
            var trHTML = "";
            const objects = JSON.parse(this.responseText);
            for (let object of objects) {
                trHTML += "<tr>";
                trHTML += "<td>" + object["idRoute"] + "</td>";
                trHTML += "<td>" + object["code"] + "</td>";
                trHTML += "<td>" + object["stations"] + "</td>";
                trHTML += "<td>" + object["assignments"] + "</td>";
                trHTML +=
                    '<td><button type="button" class="btn btn-outline-secondary" onclick="updateRoute(' + object["id"] + ')">Editar</button>';
                trHTML +=
                    '<button type="button" class="btn btn-outline-danger" onclick="deleteRoute(' + object["id"] + ')">Borrar</button></td>';
                trHTML += "</tr>";
            }
            document.getElementById("routesTable").innerHTML = trHTML;
        }
    };
}
uploadRoutes();

function editRoute() {
    Swal.fire({
        title: "Editar Ruta",
        html:
            '<input id="id" type="hidden">' +
            '<input id="code" class="swal2-input"  placeholder="Code">' +
            '<input id="stations" class="swal2-input" placeholder="Stations">' +
            '<input id="assignments" class="swal2-input" placeholder="Assignments">',
        focusConfirm: false,
        preConfirm: () => {
            createRoute();
        },
    });
}

function createRoute() {
    const code = document.getElementById("code").value;
    const stations = document.getElementById("stations").value;
    const assignments = document.getElementById("assignments").value;

    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8080/api/route/create");
        xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(
        JSON.stringify({
            code: code,
            stations: stations,
            assignments: assignments
        })
    );
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            const objects = JSON.parse(this.responseText);
            Swal.fire(objects["message"]);
            uploadRoutes();
        }
    };
}

function updateRoute(id) {
    console.log(id);
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/api/route/read/" + id );
        xhttp.send();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            const obj = JSON.parse(this.responseText);
            console.log(obj.idRoute);
            Swal.fire({
                title: "Editar Ruta",
                html:
                    '<input id="id" type="hidden" value=' +
                    obj.idRoute +
                    ">" +
                    '<input id="code" class="swal2-input" placeholder="Code" value="' +
                    obj.code +
                    '">' +
                    '<input id="stations" class="swal2-input" placeholder="Stations" value="' +
                    obj.stations +
                    '">' +
                    '<input id="assignments" class="swal2-input" placeholder="Assignments" value="' +
                    obj.assignments +
                    '">',
                focusConfirm: false,
                preConfirm: () => {
                    editarRuta(obj.id);
                },
            });
        }
    };
}

function editarRuta(id) {
    const code = document.getElementById("code").value;
    const stations = document.getElementById("stations").value;
    const assignments = document.getElementById("assignments").value;

    const xhttp = new XMLHttpRequest();
    xhttp.open("PUT", "http://localhost:8080/api/routa/update/" + id );
        xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(
        JSON.stringify({
            idRoute: id,
            code: code,
            stations: stations,
            assignments: assignments
        })
    );
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            const objects = JSON.parse(this.responseText);
            Swal.fire(objects["message"]);
            uploadRoutes();
        }
    };
}
function deleteRoute(id) {
    const xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "http://localhost:8080/api/route/delete/" + id );
        xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(
        JSON.stringify({
            id: id,
        })
    );
    xhttp.onreadystatechange = function () {
        if (this.status == 204) {
            Swal.fire("Ruta eliminada");
            uploadRoutes();
        }
    };
}



