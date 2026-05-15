package com.reportatucalle.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.reportatucalle.model.Incidencia;
import com.reportatucalle.service.IncidenciaService;

@RestController
@RequestMapping("/api/incidencias")
@CrossOrigin(origins = "*")
public class IncidenciaController {
    private final IncidenciaService service;

    public IncidenciaController(IncidenciaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Incidencia> listar() {
        return service.listar();
    }

    @PostMapping
    public Incidencia registrar(@RequestBody Incidencia incidencia) {
        return service.registrar(incidencia);
    }

    @PostMapping("/con-archivo")
    public Incidencia registrarConArchivo(@RequestParam String titulo,
                                          @RequestParam String descripcion,
                                          @RequestParam String tipo,
                                          @RequestParam String direccion,
                                          @RequestParam(required = false) String reportante,
                                          @RequestParam(required = false) MultipartFile archivo) throws IOException {
        Incidencia inc = new Incidencia();
        inc.setTitulo(titulo);
        inc.setDescripcion(descripcion);
        inc.setTipo(tipo);
        inc.setDireccion(direccion);
        inc.setReportante(reportante);

        if (archivo != null && !archivo.isEmpty()) {
            File carpeta = new File("uploads");
            carpeta.mkdirs();
            File destino = new File(carpeta, archivo.getOriginalFilename());
            archivo.transferTo(destino);
            inc.setArchivoNombre(archivo.getOriginalFilename());
        }
        return service.registrar(inc);
    }

    @PutMapping("/{id}/estado")
    public Incidencia cambiarEstado(@PathVariable String id, @RequestBody Map<String, String> body) {
        return service.cambiarEstado(id, body.get("estado"));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        service.eliminar(id);
    }
}
