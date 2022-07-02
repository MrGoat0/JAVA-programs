package model;

import static org.junit.jupiter.api.Assertions.*;

class CuentaBancoTest {

    @org.junit.jupiter.api.Test
    void depositar() {
        CuentaCorriente c = new CuentaCorriente("1234", "John", 50_000, 7_000);
        c.depositar(600_000);
        c.cobrarCuotaManejo();
        assertEquals("1234", c.getNumeroCuenta());
        assertEquals("John", c.getNombrePropietario());
        assertEquals(643_000, c.getSaldo());
        assertEquals(7_000, c.getCuotaManejo());

    }

    @org.junit.jupiter.api.Test
    void retirar() {
        CuentaCorriente c = new CuentaCorriente("1234", "John", 50_000, 7_000);
        c.depositar(600_000);
        c.cobrarCuotaManejo();
        c.retirar(150_000);
        assertEquals("1234", c.getNumeroCuenta());
        assertEquals("John", c.getNombrePropietario());
        assertEquals(485_500, c.getSaldo());
        assertEquals(7_000, c.getCuotaManejo());

    }
}