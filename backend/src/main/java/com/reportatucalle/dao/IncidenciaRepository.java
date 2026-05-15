package com.reportatucalle.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.reportatucalle.model.Incidencia;

public interface IncidenciaRepository extends MongoRepository<Incidencia, String> {
}
