package com.reportatucalle.config;

public class ConexionMongoSingleton {
    private static ConexionMongoSingleton instancia;
    private String nombreBD;

    private ConexionMongoSingleton() {
        nombreBD = "reportatucalle";
    }

    public static ConexionMongoSingleton getInstancia() {
        if (instancia == null) {
            instancia = new ConexionMongoSingleton();
        }
        return instancia;
    }

    public String getNombreBD() {
        return nombreBD;
    }
}
