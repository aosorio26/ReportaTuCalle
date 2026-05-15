package com.reportatucalle;

import static org.mockito.Mockito.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.reportatucalle.model.Incidencia;
import com.reportatucalle.observer.IncidenciaObserver;
import com.reportatucalle.service.NotificadorIncidencias;

public class ObserverTest {
    @Test
    void notificadorDebeAvisarAObservador() {
        IncidenciaObserver obs = mock(IncidenciaObserver.class);
        NotificadorIncidencias n = new NotificadorIncidencias(List.of(obs));
        Incidencia inc = new Incidencia();
        n.notificar(inc);
        verify(obs, times(1)).actualizar(inc);
    }
}
