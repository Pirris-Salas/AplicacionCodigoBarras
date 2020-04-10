/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author INVENIO122
 */
public class clsJornadas {
    
    
    private String tiempo;
    private String horaInicio;
    private String horaSalida;
private int idJornada;
    public clsJornadas() {
    }

    public clsJornadas( String tiempo, String horaInicio, String horaSalida, int idJornada) {
        
        this.tiempo = tiempo;
        this.horaInicio = horaInicio;
        this.horaSalida = horaSalida;
        this.idJornada = idJornada;
    }

    public int getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(int idJornada) {
        this.idJornada = idJornada;
    }

 
    

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }
    
    
    
}
