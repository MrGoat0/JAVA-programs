package Model;

public abstract class Asiento {

    private char tipo;
    private String ID;
    private boolean pantallaEncendida;
    private double inclinacionSilla;
    private boolean luzLecturaEncendida;
    protected boolean luzAsistenciaEncendida;
    private boolean aireAcondicionadoEncendido;

    public Asiento(char tipo, String ID) {
        this.tipo = tipo;
        this.ID = ID;
        this.pantallaEncendida = false;
        this.inclinacionSilla = 90;
        this.luzLecturaEncendida = false;
        this.luzAsistenciaEncendida = false;
        this.aireAcondicionadoEncendido = false;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public boolean isPantallaEncendida() {
        return pantallaEncendida;
    }

    public void setPantallaEncendida(boolean pantallaEncendida) {
        this.pantallaEncendida = pantallaEncendida;
    }

    public double getInclinacionSilla() {
        return inclinacionSilla;
    }

    public void setInclinacionSilla(double inclinacionSilla) {
        this.inclinacionSilla = inclinacionSilla;
    }

    public boolean isLuzLecturaEncendida() {
        return luzLecturaEncendida;
    }

    public void setLuzLecturaEncendida(boolean luzLecturaEncendida) {
        this.luzLecturaEncendida = luzLecturaEncendida;
    }

    public boolean isLuzAsistenciaEncendida() {
        return luzAsistenciaEncendida;
    }

    public void setLuzAsistenciaEncendida(boolean luzAsistenciaEncendida) {
        this.luzAsistenciaEncendida = luzAsistenciaEncendida;
    }
    public boolean isAireAcondicionadoEncendido() {
        return aireAcondicionadoEncendido;
    }

    public void setAireAcondicionadoEncendido(boolean aireAcondicionadoEncendido) {
        this.aireAcondicionadoEncendido = aireAcondicionadoEncendido;
    }
    public void gestionarAireAcondicionado(){
        if (aireAcondicionadoEncendido){
            aireAcondicionadoEncendido=false;
        }else {
            aireAcondicionadoEncendido=true;
        }
    }
    public void gestionarPantalla(){
        if (pantallaEncendida){
            pantallaEncendida=false;
        }else{
            pantallaEncendida=true;
        }
    }
    public void gestionarLuzLectura(){
        if (luzLecturaEncendida){
            luzLecturaEncendida=false;
        }else {
            luzLecturaEncendida=true;
        }
    }
    public void gestionarLuzAsistencia(){
         if (luzAsistenciaEncendida){
             luzAsistenciaEncendida=false;
         }else {
             luzAsistenciaEncendida=true;
         }
    }
    public void aumentarInclinacion(double inclinacion){
        double preview = inclinacionSilla+inclinacion;
        if ((preview) > 135){
            inclinacionSilla=135;
        }else {
            inclinacionSilla=preview;
        }
    }
    public void disminuirInclinacion(double inclinacion){
        double preview= inclinacionSilla-inclinacion;
        if ((preview) < 0){
            inclinacionSilla=0;
        }else {
            inclinacionSilla=preview;
        }
    }
    public abstract String imprimirMenuPantalla();
}
