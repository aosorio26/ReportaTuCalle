package com.reportatucalle.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.reportatucalle.model.Incidencia;

@Repository
public class MongoIncidenciaDao implements IncidenciaDao {
    private final IncidenciaRepository repo;

    public MongoIncidenciaDao(IncidenciaRepository repo) {
        this.repo = repo;
    }

    public Incidencia guardar(Incidencia incidencia) {
        return repo.save(incidencia);
    }

    public List<Incidencia> listar() {
        return repo.findAll();
    }

    public Optional<Incidencia> buscarPorId(String id) {
        return repo.findById(id);
    }

    public void eliminar(String id) {
        repo.deleteById(id);
    }
}
