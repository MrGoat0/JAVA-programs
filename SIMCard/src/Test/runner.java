package Test;

import model.SIMCard;

public class runner {
    public static void main(String[] args) {
        SIMCard cliente = new SIMCard("3132593938");
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
        System.out.println(cliente.getEmpresaTelefonia());
        System.out.println(cliente.getSaldo());
        System.out.println(cliente.getNumeroTelefono());
        System.out.println(cliente.isCelularApagado());
        System.out.println(cliente.isModoAvionActivado());
        System.out.println(cliente.isDatosActivados());
        System.out.println(cliente.getSaldoDatos());


    }
}
