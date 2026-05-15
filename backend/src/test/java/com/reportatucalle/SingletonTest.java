package com.reportatucalle;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.reportatucalle.config.ConexionMongoSingleton;

public class SingletonTest {
    @Test
    void singletonDebeSerMismaInstancia() {
        ConexionMongoSingleton a = ConexionMongoSingleton.getInstancia();
        ConexionMongoSingleton b = ConexionMongoSingleton.getInstancia();
        assertSame(a, b);
        assertEquals("reportatucalle", a.getNombreBD());
    }
}
