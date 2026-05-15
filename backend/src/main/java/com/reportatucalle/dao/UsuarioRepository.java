package com.reportatucalle.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.reportatucalle.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Usuario findByCorreo(String correo);
}
