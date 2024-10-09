function uploadSchedules() {
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/api/schedule/all");
    xhttp.send();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
            var trHTML = "";
            const objects = JSON.parse(this.responseText);
            for (let object of objects) {
                trHTML += "<tr>";
                trHTML += "<td>" + object["idSchedule"] + "</td>";
                trHTML += "<td>" + object["days"] + "</td>";
                trHTML += "<td>" + object["timeStart"] + "</td>";
                trHTML += "<td>" + object["timeEnd"] + "</td>";
                trHTML += "<td>" + object["assignments"] + "</td>";
                trHTML +=
                    '<td><button type="button" class="btn btn-outline-secondary" onclick="updateSchedule(' + object["id"] + ')">Editar</button>';
                trHTML +=
                    '<button type="button" class="btn btn-outline-danger" onclick="deleteSchedule(' + object["id"] + ')">Borrar</button></td>';
                trHTML += "</tr>";
            }
            document.getElementById("schedulesTable").innerHTML = trHTML;
        }
    };
}
uploadSchedules();

function editSchedule() {
    Swal.fire({
        title: "Editar Horario",
        html:
            '<input id="id" type="hidden">' +
            '<input id="days" class="swal2-input"  placeholder="Days">' +
            '<input id="timeStart" class="swal2-input" placeholder="TimeStart">' +
            '<input id="timeEnd" class="swal2-input" placeholder="TimeEnd">' +
            '<input id="assignments" class="swal2-input" placeholder="Assignments">',
        focusConfirm: false,
        preConfirm: () => {
            createSchedule();
        },
    });
}

function createSchedule() {
    const days = document.getElementById("days").value;
    const timeStart = document.getElementById("timeStart").value;
    const timeEnd = document.getElementById("timeEnd").value;
    const assignments = document.getElementById("assignments").value;

    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8080/api/schedule/create");
        xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(
        JSON.stringify({
            days: days,
            timeStart: timeStart,
            timeEnd: timeEnd,
            assignments: assignments
        })
    );
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            const objects = JSON.parse(this.responseText);
            Swal.fire(objects["message"]);
            uploadSchedules();
        }
    };
}

function updateSchedule(id) {
    console.log(id);
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/api/schedule/read/" + id );
        xhttp.send();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            const obj = JSON.parse(this.responseText);
            console.log(obj.idSchedule);
            Swal.fire({
                title: "Editar Horario",
                html:
                    '<input id="id" type="hidden" value=' +
                    obj.idSchedule +
                    ">" +
                    '<input id="days" class="swal2-input" placeholder="days" value="' +
                    obj.days +
                    '">' +
                    '<input id="timeStart" class="swal2-input" placeholder="timeStart" value="' +
                    obj.timeStart +
                    '">' +
                    '<input id="timeEnd" class="swal2-input" placeholder="timeEnd" value="' +
                    obj.timeEnd +
                    '">' +
                    '<input id="assignments" class="swal2-input" placeholder="Assignments" value="' +
                    obj.assignments +
                    '">',
                focusConfirm: false,
                preConfirm: () => {
                    editarHorario(obj.id);
                },
            });
        }
    };
}

function editarHorario(id) {
    const days = document.getElementById("days").value;
    const timeStart = document.getElementById("timeStart").value;
    const timeEnd = document.getElementById("timeEnd").value;
    const assignments = document.getElementById("assignments").value;

    const xhttp = new XMLHttpRequest();
    xhttp.open("PUT", "http://localhost:8080/api/schedule/update/" + id );
        xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(
        JSON.stringify({
            idSchedule: id,
            days: days,
            timeStart: timeStart,
            timeEnd: timeEnd,
            assignments: assignments
        })
    );
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            const objects = JSON.parse(this.responseText);
            Swal.fire(objects["message"]);
            uploadSchedules();
        }
    };
}
function deleteSchedule(id) {
    const xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "http://localhost:8080/api/schedule/delete/" + id );
        xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(
        JSON.stringify({
            id: id,
        })
    );
    xhttp.onreadystatechange = function () {
        if (this.status == 204) {
            Swal.fire("Horario eliminado");
            uploadSchedules();
        }
    };
}



