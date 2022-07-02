public class runner {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        Pedido pedido1 = new Pedido("123", "456", 10_000, 1, 2, 2021 );
        Pedido pedido2 = new Pedido("456", "159", 20_000, 1, 2, 2021 );
        Pedido pedido3 = new Pedido("789", "753", 30_000, 1, 2, 2021 );
        restaurante.agregarPedidoLista(pedido1);
        restaurante.agregarPedidoLista(pedido2);
        restaurante.agregarPedidoLista(pedido3);
        double n= restaurante.desviacionEstandarGananciasTotales();
        System.out.println(n);
    }
}
