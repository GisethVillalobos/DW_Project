function uploadAssignments() {
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/api/assignment/all");
    xhttp.send();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
            var trHTML = "";
            const objects = JSON.parse(this.responseText);
            for (let object of objects) {
                trHTML += "<tr>";
                trHTML += "<td>" + object["idAssignment"] + "</td>";
                trHTML += "<td>" + object["driver"] + "</td>";
                trHTML += "<td>" + object["bus"] + "</td>";
                trHTML += "<td>" + object["route"] + "</td>";
                trHTML += "<td>" + object["schedule"] + "</td>";
                trHTML +=
                    '<td><button type="button" class="btn btn-outline-secondary" onclick="updateAssignment(' + object["id"] + ')">Editar</button>';
                trHTML +=
                    '<button type="button" class="btn btn-outline-danger" onclick="deleteAssignment(' + object["id"] + ')">Borrar</button></td>';
                trHTML += "</tr>";
            }
            document.getElementById("assignmentsTable").innerHTML = trHTML;
        }
    };
}
uploadAssignments();

function editAssignment() {
    Swal.fire({
        title: "Editar Asignación",
        html:
            '<input id="id" type="hidden">' +
            '<input id="driver" class="swal2-input"  placeholder="Driver">' +
            '<input id="bus" class="swal2-input" placeholder="Bus">' +
            '<input id="route" class="swal2-input" placeholder="Route">' +
            '<input id="schedule" class="swal2-input" placeholder="Schedule">',
        focusConfirm: false,
        preConfirm: () => {
            createAssignment();
        },
    });
}

function createAssignment() {
    const driver = document.getElementById("driver").value;
    const bus = document.getElementById("bus").value;
    const route = document.getElementById("route").value;
    const schedule = document.getElementById("schedule").value;

    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8080/api/assignment/create");
        xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(
        JSON.stringify({
            driver: driver,
            bus: bus,
            route: route,
            schedule: schedule
        })
    );
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            const objects = JSON.parse(this.responseText);
            Swal.fire(objects["message"]);
            uploadAssignments();
        }
    };
}

function updateAssignment(id) {
    console.log(id);
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/api/assignment/read/" + id );
        xhttp.send();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            const obj = JSON.parse(this.responseText);
            console.log(obj.idAssignment);
            Swal.fire({
                title: "Editar Asignación",
                html:
                    '<input id="id" type="hidden" value=' +
                    obj.idAssignment +
                    ">" +
                    '<input id="driver" class="swal2-input" placeholder="Driver" value="' +
                    obj.driver +
                    '">' +
                    '<input id="bus" class="swal2-input" placeholder="Bus" value="' +
                    obj.bus +
                    '">' +
                    '<input id="route" class="swal2-input" placeholder="Route" value="' +
                    obj.route +
                    '">' +
                    '<input id="schedule" class="swal2-input" placeholder="Schedule" value="' +
                    obj.schedule +
                    '">',
                focusConfirm: false,
                preConfirm: () => {
                    editarAsignacion(obj.id);
                },
            });
        }
    };
}

function editarAsignacion(id) {
    const driver = document.getElementById("driver").value;
    const bus = document.getElementById("bus").value;
    const route = document.getElementById("route").value;
    const schedule = document.getElementById("schedule").value;

    const xhttp = new XMLHttpRequest();
    xhttp.open("PUT", "http://localhost:8080/api/assignment/update/" + id );
        xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(
        JSON.stringify({
            idAssignment: id,
            driver: driver,
            bus: bus,
            route: route,
            schedule: schedule
        })
    );
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            const objects = JSON.parse(this.responseText);
            Swal.fire(objects["message"]);
            uploadAssignments();
        }
    };
}
function deleteAssignment(id) {
    const xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "http://localhost:8080/api/assignment/delete/" + id );
        xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(
        JSON.stringify({
            id: id,
        })
    );
    xhttp.onreadystatechange = function () {
        if (this.status == 204) {
            Swal.fire("Asignación eliminada");
            uploadAssignments();
        }
    };
}



