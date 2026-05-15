package com.reportatucalle.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.reportatucalle.config.ConexionMongoSingleton;

@RestController
public class InfoController {
    @GetMapping("/api/info")
    public Map<String, String> info() {
        return Map.of(
            "proyecto", "Reporta Tu Calle",
            "bd", ConexionMongoSingleton.getInstancia().getNombreBD(),
            "patrones", "DAO, Singleton y Observer"
        );
    }
}
