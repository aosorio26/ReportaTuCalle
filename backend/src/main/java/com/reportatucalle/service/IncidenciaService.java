package com.reportatucalle.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.reportatucalle.dao.IncidenciaDao;
import com.reportatucalle.model.Incidencia;

@Service
public class IncidenciaService {
    private final IncidenciaDao dao;
    private final NotificadorIncidencias notificador;

    public IncidenciaService(IncidenciaDao dao, NotificadorIncidencias notificador) {
        this.dao = dao;
        this.notificador = notificador;
    }

    public Incidencia registrar(Incidencia incidencia) {
        if (incidencia.getEstado() == null || incidencia.getEstado().isBlank()) {
            incidencia.setEstado("REPORTADO");
        }
        incidencia.setFechaRegistro(LocalDateTime.now());
        Incidencia guardada = dao.guardar(incidencia);
        notificador.notificar(guardada);
        return guardada;
    }

    public List<Incidencia> listar() {
        return dao.listar();
    }

    public Incidencia cambiarEstado(String id, String estado) {
        Incidencia inc = dao.buscarPorId(id).orElseThrow();
        inc.setEstado(estado);
        return dao.guardar(inc);
    }

    public void eliminar(String id) {
        dao.eliminar(id);
    }
}
