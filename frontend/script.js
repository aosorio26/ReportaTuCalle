const API_URL = "http://localhost:8080/api/incidencias";

let usuarioActual = null;
let imagenActual = "";

async function cargarReportes() {
    const lista = document.getElementById("lista");
    lista.innerHTML = "";

    try {
        const respuesta = await fetch(API_URL);
        const data = await respuesta.json();

        if (!Array.isArray(data)) {
            lista.innerHTML = "<p>Error al cargar reportes.</p>";
            console.error(data);
            return;
        }

        if (data.length === 0) {
            lista.innerHTML = "<p>No hay reportes registrados todavía.</p>";
            return;
        }

        data.forEach(r => {
            const div = document.createElement("div");
            div.className = "reporte";

            div.innerHTML = `
                <h3>${r.titulo}</h3>
                <span class="estado">${r.tipo}</span>
                <p><b>Descripción:</b> ${r.descripcion}</p>
                <p><b>Dirección:</b> ${r.direccion || r.ubicacion || ""}</p>
                <p><b>Reportante:</b> ${r.reportante || "No indicado"}</p>
                ${r.imagen ? `<img class="fotoReporte" src="${r.imagen}" alt="Imagen del reporte">` : ""}
            `;

            lista.appendChild(div);
        });
    } catch (error) {
        lista.innerHTML = "<p>No se pudo conectar con el backend.</p>";
        console.error(error);
    }
}

document.getElementById("archivo").addEventListener("change", function() {
    const archivo = this.files[0];

    if (!archivo) {
        imagenActual = "";
        return;
    }

    const lector = new FileReader();

    lector.onload = function(e) {
        imagenActual = e.target.result;
    };

    lector.readAsDataURL(archivo);
});

document.getElementById("formUsuario").addEventListener("submit", function(e) {
    e.preventDefault();

    const nombre = document.getElementById("nombreUsuario").value;
    const correo = document.getElementById("correoUsuario").value;
    const password = document.getElementById("passwordUsuario").value;

    const usuario = {
        nombre: nombre,
        correo: correo,
        password: password
    };

    localStorage.setItem("usuarioRTC", JSON.stringify(usuario));

    document.getElementById("usuarioGuardado").innerHTML = `
        <div class="usuario">
            <h3>Usuario registrado</h3>
            <p><b>Nombre:</b> ${nombre}</p>
            <p><b>Correo:</b> ${correo}</p>
        </div>
    `;

    alert("Usuario registrado correctamente");
    this.reset();
});

document.getElementById("formLogin").addEventListener("submit", function(e) {
    e.preventDefault();

    const correo = document.getElementById("loginCorreo").value;
    const password = document.getElementById("loginPassword").value;

    const guardado = localStorage.getItem("usuarioRTC");

    if (guardado === null) {
        alert("Primero debes registrar un usuario.");
        return;
    }

    const usuario = JSON.parse(guardado);

    if (usuario.correo === correo && usuario.password === password) {
        usuarioActual = usuario;

        document.getElementById("sesionActiva").innerHTML = `
            <div class="usuario">
                <h3>Sesión iniciada</h3>
                <p><b>Usuario:</b> ${usuario.nombre}</p>
                <p><b>Correo:</b> ${usuario.correo}</p>
            </div>
        `;

        document.getElementById("reportante").value = usuario.nombre;

        alert("Inicio de sesión correcto");
        this.reset();
    } else {
        alert("Correo o contraseña incorrectos.");
    }
});

document.getElementById("formReporte").addEventListener("submit", async function(e) {
    e.preventDefault();

    if (usuarioActual === null) {
        alert("Primero inicia sesión para registrar un reporte.");
        return;
    }

    const reporte = {
        titulo: document.getElementById("titulo").value,
        descripcion: document.getElementById("descripcion").value,
        tipo: document.getElementById("tipo").value,
        direccion: document.getElementById("direccion").value,
        ubicacion: document.getElementById("direccion").value,
        reportante: usuarioActual.nombre,
        imagen: imagenActual
    };

    try {
        const respuesta = await fetch(API_URL, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(reporte)
        });

        if (!respuesta.ok) {
            alert("Error al guardar reporte.");
            return;
        }

        alert("Reporte guardado correctamente");

        this.reset();
        imagenActual = "";

        document.getElementById("reportante").value = usuarioActual.nombre;

        cargarReportes();
    } catch (error) {
        console.error(error);
        alert("No se pudo conectar con el backend.");
    }
});

cargarReportes();