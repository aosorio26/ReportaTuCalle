package com.reportatucalle.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.reportatucalle.dao.UsuarioRepository;
import com.reportatucalle.model.Usuario;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public Usuario registrar(Usuario usuario) {
        return repo.save(usuario);
    }

    public List<Usuario> listar() {
        return repo.findAll();
    }

    public boolean login(String correo, String clave) {
        Usuario u = repo.findByCorreo(correo);
        return u != null && u.getClave().equals(clave);
    }
}
