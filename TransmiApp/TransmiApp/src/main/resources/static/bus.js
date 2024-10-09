function uploadBuses() {
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/api/bus/all");
    xhttp.send();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
            var trHTML = "";
            const objects = JSON.parse(this.responseText);
            for (let object of objects) {
                trHTML += "<tr>";
                trHTML += "<td>" + object["idBus"] + "</td>";
                trHTML += "<td>" + object["plate"] + "</td>";
                trHTML += "<td>" + object["model"] + "</td>";
                trHTML += "<td>" + object["assignments"] + "</td>";
                trHTML +=
                    '<td><button type="button" class="btn btn-outline-secondary" onclick="updateBus(' + object["id"] + ')">Editar</button>';
                trHTML +=
                    '<button type="button" class="btn btn-outline-danger" onclick="deleteBus(' + object["id"] + ')">Borrar</button></td>';
                trHTML += "</tr>";
            }
            document.getElementById("busesTable").innerHTML = trHTML;
        }
    };
}
uploadBuses();

function editBus() {
    Swal.fire({
        title: "Editar Bus",
        html:
            '<input id="id" type="hidden">' +
            '<input id="plate" class="swal2-input"  placeholder="Plate">' +
            '<input id="model" class="swal2-input" placeholder="Model">' +
            '<input id="assignments" class="swal2-input" placeholder="Assignments">',
        focusConfirm: false,
        preConfirm: () => {
            createBus();
        },
    });
}

function createBus() {
    const plate = document.getElementById("plate").value;
    const model = document.getElementById("model").value;
    const assignments = document.getElementById("assignments").value;

    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8080/api/bus/create");
        xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(
        JSON.stringify({
            plate: plate,
            model: model,
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
            console.log(obj.idBus);
            Swal.fire({
                title: "Editar Bus",
                html:
                    '<input id="id" type="hidden" value=' +
                    obj.idBus +
                    ">" +
                    '<input id="plate" class="swal2-input" placeholder="Plate" value="' +
                    obj.plate +
                    '">' +
                    '<input id="model" class="swal2-input" placeholder="Model" value="' +
                    obj.model +
                    '">' +
                    '<input id="assignments" class="swal2-input" placeholder="Assignments" value="' +
                    obj.assignments +
                    '">',
                focusConfirm: false,
                preConfirm: () => {
                    editarBus(obj.id);
                },
            });
        }
    };
}

function editarBus(id) {
    const plate = document.getElementById("plate").value;
    const model = document.getElementById("model").value;
    const assignments = document.getElementById("assignments").value;

    const xhttp = new XMLHttpRequest();
    xhttp.open("PUT", "http://localhost:8080/api/bus/update/" + id );
        xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(
        JSON.stringify({
            idBus: id,
            plate: plate,
            model: model,
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
function deleteBus(id) {
    const xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "http://localhost:8080/api/bus/delete/" + id );
        xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(
        JSON.stringify({
            id: id,
        })
    );
    xhttp.onreadystatechange = function () {
        if (this.status == 204) {
            Swal.fire("Bus eliminado");
            uploadBuses();
        }
    };
}



