package com.reportatucalle.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.reportatucalle.model.Incidencia;
import com.reportatucalle.observer.IncidenciaObserver;

@Service
public class NotificadorIncidencias {
    private final List<IncidenciaObserver> observadores;

    public NotificadorIncidencias(List<IncidenciaObserver> observadores) {
        this.observadores = observadores;
    }

    public void notificar(Incidencia incidencia) {
        for (IncidenciaObserver obs : observadores) {
            obs.actualizar(incidencia);
        }
    }
}
