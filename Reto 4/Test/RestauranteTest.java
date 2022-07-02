import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RestauranteTest {
    private Restaurante restaurante;
    private void setup(){
        restaurante = new Restaurante();
        Pedido pedido1 = new Pedido("123", "456", 10_000, 1, 2, 2021 );
        restaurante.agregarPedidoLista(pedido1);

    }

    @Test
    void agregarPedidoLista() {
        setup();
        ArrayList<Pedido> clonPedido=restaurante.getPedidos();
        assertEquals(1, clonPedido.size() );
        Pedido pedido1 = new Pedido("123", "456", 10_000, 1, 2, 2021 );
        restaurante.agregarPedidoLista(pedido1);
        assertEquals(1, clonPedido.size() );
    }
    @Test
    void eliminarPedido(){
        setup();
        Pedido pedido1 = new Pedido("123", "456", 10_000, 1, 2, 2021 );
        restaurante.eliminarPedido(pedido1.getnPedido());
        ArrayList<Pedido> clonPedido=restaurante.getPedidos();
        assertEquals(0, clonPedido.size() );
    }
    @Test
    void calcularGanancias(){
        setup();
        Pedido pedido1 = new Pedido("456", "159", 20_000, 1, 2, 2021 );
        Pedido pedido2 = new Pedido("789", "753", 30_000, 1, 2, 2021 );
        restaurante.agregarPedidoLista(pedido1);
        restaurante.agregarPedidoLista(pedido2);
        assertEquals(60_000, restaurante.calcularGanancias());
    }
    @Test
    void CalcularPromedio(){
        setup();
        Pedido pedido1 = new Pedido("456", "159", 20_000, 1, 2, 2021 );
        Pedido pedido2 = new Pedido("789", "753", 30_000, 1, 2, 2021 );
        restaurante.agregarPedidoLista(pedido1);
        restaurante.agregarPedidoLista(pedido2);
        assertEquals(20_000, restaurante.promedioGananciasTotales());
    }
    @Test
    void desviaciónEstandar(){
        setup();
        Pedido pedido1 = new Pedido("456", "159", 20_000, 1, 2, 2021 );
        Pedido pedido2 = new Pedido("789", "753", 30_000, 1, 2, 2021 );
        restaurante.agregarPedidoLista(pedido1);
        restaurante.agregarPedidoLista(pedido2);
        assertEquals(8164.965809, restaurante.desviacionEstandarGananciasTotales(), 0.1);

    }
    @Test
    void costoID(){
        setup();
        Pedido pedido1 = new Pedido("456", "159", 20_000, 1, 2, 2021 );
        Pedido pedido2 = new Pedido("789", "753", 30_000, 1, 2, 2021 );
        restaurante.agregarPedidoLista(pedido1);
        restaurante.agregarPedidoLista(pedido2);
        assertEquals(30_000, restaurante.retornarCostoPedido("789"));
    }
}