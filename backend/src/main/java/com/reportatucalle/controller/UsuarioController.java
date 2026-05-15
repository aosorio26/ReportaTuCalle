package com.reportatucalle.controller;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.*;
import com.reportatucalle.model.Usuario;
import com.reportatucalle.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @PostMapping("/registro")
    public Usuario registrar(@RequestBody Usuario usuario) {
        return service.registrar(usuario);
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Usuario usuario) {
        boolean ok = service.login(usuario.getCorreo(), usuario.getClave());
        return Map.of("ok", ok, "mensaje", ok ? "Login correcto" : "Datos incorrectos");
    }
}
