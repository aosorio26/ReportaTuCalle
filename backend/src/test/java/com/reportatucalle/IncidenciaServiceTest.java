package com.reportatucalle;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.*;
import org.junit.jupiter.api.Test;
import com.reportatucalle.dao.IncidenciaDao;
import com.reportatucalle.model.Incidencia;
import com.reportatucalle.service.IncidenciaService;
import com.reportatucalle.service.NotificadorIncidencias;

public class IncidenciaServiceTest {
    @Test
    void registrarDebeGuardarIncidencia() {
        IncidenciaDao dao = mock(IncidenciaDao.class);
        NotificadorIncidencias notificador = mock(NotificadorIncidencias.class);
        IncidenciaService service = new IncidenciaService(dao, notificador);

        Incidencia inc = new Incidencia();
        inc.setTitulo("Bache");
        inc.setTipo("BACHE");
        when(dao.guardar(any(Incidencia.class))).thenReturn(inc);

        Incidencia r = service.registrar(inc);

        assertEquals("Bache", r.getTitulo());
        verify(dao, times(1)).guardar(inc);
        verify(notificador, times(1)).notificar(inc);
    }

    @Test
    void listarDebeRetornarDatos() {
        IncidenciaDao dao = mock(IncidenciaDao.class);
        NotificadorIncidencias notificador = mock(NotificadorIncidencias.class);
        IncidenciaService service = new IncidenciaService(dao, notificador);
        when(dao.listar()).thenReturn(List.of(new Incidencia(), new Incidencia()));
        assertEquals(2, service.listar().size());
    }
}
