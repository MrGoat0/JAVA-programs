package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SIMCardTest {
    private SIMCard cliente;
    private  void setup(){
        SIMCard cliente = new SIMCard("3132593938");
        //cliente.recargarSaldo(50000);
        //cliente.comprarDatos(12);
        //cliente.consumirDatos(3);
        //cliente.gestionarEncendidoCelular();
        //cliente.llamar(120);
        //cliente.gestionarModoAvion();
        //cliente.gestionarDatos();
        //cliente.gestionarModoAvion();
        //cliente.gestionarDatos();
        //cliente.consumirDatos(3);
        //cliente.gestionarEncendidoCelular();

    }

    @org.junit.jupiter.api.Test
    void getEmpresa(){
        setup();
        cliente.recargarSaldo(50000);
        cliente.comprarDatos(12);
        cliente.consumirDatos(3);
        cliente.gestionarEncendidoCelular();
        cliente.llamar(120);
        cliente.gestionarModoAvion();
        cliente.gestionarDatos();
        cliente.gestionarModoAvion();
        cliente.gestionarDatos();
        cliente.consumirDatos(3);
        cliente.gestionarEncendidoCelular();
        assertEquals("HI", cliente.getEmpresaTelefonia());
    }
    @org.junit.jupiter.api.Test
    void getSaldo(){
        setup();
        assertEquals(14910, cliente.getSaldo());
    }
    @org.junit.jupiter.api.Test
    void getNumero(){
        setup();
        assertEquals("3132593938", cliente.getNumeroTelefono());
    }
    @org.junit.jupiter.api.Test
    void isApagado(){
        setup();
        assertTrue(cliente.isCelularApagado());
    }
    @org.junit.jupiter.api.Test
    void ismodoAvion(){
        setup();
        assertFalse( cliente.isModoAvionActivado());
    }
    @org.junit.jupiter.api.Test
    void isDatos(){
        setup();
        assertFalse( cliente.isDatosActivados());
    }


    @org.junit.jupiter.api.Test
    void getSaldoDatos() {
        setup();
        //
        assertEquals(9, cliente.getSaldoDatos());
    }
}