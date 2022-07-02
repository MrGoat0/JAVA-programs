package model;

public class SIMCard{
    //Atributos de la clase.
    private String empresaTelefonia;
    private double saldo;
    private String numeroTelefono;
    private boolean celularApagado;
    private boolean modoAvionActivado;
    private boolean datosActivados;
    private int saldoDatos;
    //Constructor; en este caso solo vamos a pedir al usar la clase el número de celular y los demás parametros serán inicializados.
    public SIMCard(String numeroTelefono) {
        this.empresaTelefonia = "HI";
        this.saldo = 0;
        this.numeroTelefono = numeroTelefono;
        this.celularApagado = true;
        this.modoAvionActivado = false;
        this.datosActivados = false;
        this.saldoDatos = 0;
    }
    //getters and setters de los diferentes atributos de la clase.
    public String getEmpresaTelefonia() {
        return empresaTelefonia;
    }

    public void setEmpresaTelefonia(String empresaTelefonia) {
        this.empresaTelefonia = empresaTelefonia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public boolean isCelularApagado() {
        return celularApagado;
    }

    public void setCelularApagado(boolean celularApagado) {
        this.celularApagado = celularApagado;
    }

    public boolean isModoAvionActivado() {
        return modoAvionActivado;
    }

    public void setModoAvionActivado(boolean modoAvionActivado) {
        this.modoAvionActivado = modoAvionActivado;
    }

    public boolean isDatosActivados() {
        return datosActivados;
    }

    public void setDatosActivados(boolean datosActivados) {
        this.datosActivados = datosActivados;
    }

    public int getSaldoDatos() {
        return saldoDatos;
    }

    public void setSaldoDatos(int saldoDatos) {
        this.saldoDatos = saldoDatos;
    }
    //Se realiza la compra de datos, no importa si esta apagado o encendido el celular.
    public void comprarDatos(int cantCompra) {
        if (cantCompra <= 10) {
            int subTotal = cantCompra*3_000;
            if (subTotal <= saldo) {
                saldo -= subTotal;
                saldoDatos += cantCompra;
            }
        }
        else if (cantCompra > 10 && cantCompra < 30) {
            int sobra = Math.abs(cantCompra - 10);
            int diezPrimeras = 10 * 3_000;
            int masDeDiez = sobra * 2_500;
            int subTotal = diezPrimeras + masDeDiez;
            if (subTotal <= saldo) {
                saldo -= (diezPrimeras + masDeDiez);
                saldoDatos += cantCompra;
            }
        }
        else if (cantCompra > 30) {
            int sobra = Math.abs(cantCompra - 20);
            int veintePrimeras = 20 * 3_000;
            int masDeVeinte = sobra * 1_500;
            int subTotal = veintePrimeras + masDeVeinte;
            if (subTotal <= saldo) {
                saldo -= (veintePrimeras + masDeVeinte);
                saldoDatos += cantCompra;
            }
        }
    }
    public void consumirDatos(int cantConsumo) {
        int sub = saldoDatos-cantConsumo;
        if (celularApagado) {
        }
        else if (sub>0) {
            saldoDatos -= cantConsumo;
        }
    }
    public void llamar(int cantSegGastados) {
        if (celularApagado==false) {
            if (cantSegGastados <= 60) {

                saldo -= cantSegGastados ;
            }
            else if (cantSegGastados > 60) {
                int sobra = Math.abs(cantSegGastados - 60);
                double masDeSesenta = sobra * 0.5;
                double subTotal = 60 + masDeSesenta;
                saldo -= subTotal;
            }
        }
    }
    public void recargarSaldo(double cantRecarga){
        saldo+=cantRecarga;
    }
    public void gestionarEncendidoCelular(){
        if (celularApagado){
            celularApagado=false;
            modoAvionActivado=false;
            datosActivados=false;
        }
        else {celularApagado=true;
            modoAvionActivado=false;
            datosActivados=false;
        }
    }
    public void gestionarModoAvion(){
        if (modoAvionActivado==false && celularApagado==false){
            modoAvionActivado=true;
            datosActivados=false;
        }
        else if (modoAvionActivado){
            modoAvionActivado=false;
            datosActivados=false;
        }
    }
    public void gestionarDatos(){
        if (datosActivados==false && celularApagado==false && modoAvionActivado==false){
            datosActivados=true;
        }
    }
}
