import java.util.ArrayList;

public class Restaurante{

    private ArrayList<Pedido>pedidos = null;

    public Restaurante(){ pedidos= new ArrayList<>();}

    public ArrayList<Pedido> getPedidos() {
        return (ArrayList<Pedido>) pedidos.clone();
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void agregarPedidoLista(Pedido p){
        if (pedidos.size()==0){
            pedidos.add(p);
        }
        else {
            for (int i=0; i<pedidos.size(); i++){
                if (pedidos.get(i).getnPedido() == p.getnPedido()){
                    continue;
                }
                else{
                    pedidos.add(p);
                    break;
                }
            }
        }
    }
    public void eliminarPedido(String nPedido){
        for (int i=0; i<pedidos.size();i++){
            if ( pedidos.get(i).getnPedido()==nPedido) {
                pedidos.remove(i);
            }
            else { continue; }
        }
    }
    public double calcularGanancias(){
        double suma = 0;
        for (int i = 0; i < pedidos.size(); i++) {
            suma+=pedidos.get(i).getCostoPedido();
        }
        return suma;
    }
    public double promedioGananciasTotales(){
        double contador= 0;
        double suma=0.0;
        for (Pedido pedido: pedidos) {
            suma+=pedido.getCostoPedido();
            contador+=1;
        }
        return suma/contador;
    }
    public double desviacionEstandarGananciasTotales(){
        double n = getPedidos().size();
        double sumaCuadrada = 0;
        for (int i = 0; i < n ; i++) {
            sumaCuadrada+=(Math.pow(pedidos.get(i).getCostoPedido()-promedioGananciasTotales(), 2));
        }
        return Math.pow(((double) 1/n)*(sumaCuadrada), (double)1/2);
    }
    public double retornarCostoPedido(String ID){
        double costo = 0.0;
        for (Pedido pedido: pedidos) {
            if (pedido.getnPedido()==ID){
                costo = pedido.getCostoPedido();
                break;
            }
        }
        return costo;
    }
}
