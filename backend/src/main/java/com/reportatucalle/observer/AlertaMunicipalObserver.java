package com.reportatucalle.observer;

import org.springframework.stereotype.Component;
import com.reportatucalle.model.Incidencia;

@Component
public class AlertaMunicipalObserver implements IncidenciaObserver {
    public void actualizar(Incidencia incidencia) {
        System.out.println("ALERTA: nueva incidencia registrada -> " + incidencia.getTipo() + " / " + incidencia.getTitulo());
    }
}
