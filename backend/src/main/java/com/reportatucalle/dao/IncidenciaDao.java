package com.reportatucalle.dao;

import java.util.List;
import java.util.Optional;
import com.reportatucalle.model.Incidencia;

public interface IncidenciaDao {
    Incidencia guardar(Incidencia incidencia);
    List<Incidencia> listar();
    Optional<Incidencia> buscarPorId(String id);
    void eliminar(String id);
}
