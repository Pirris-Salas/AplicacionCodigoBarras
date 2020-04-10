/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;
import java.sql.Date;
/**
 *
 * @author INVENIO122
 */
public class clsHorarios {
    
    
    private int idHorario;
    private int idJornada;
    private int idUusuario;
    private Date date;
    private Date fechaFinal;

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public clsHorarios() {
    }

    public clsHorarios(int idHorario, int idJornada, int idUusuario, Date date,Date fechaFinal) {
        this.idHorario = idHorario;
        this.idJornada = idJornada;
        this.idUusuario = idUusuario;
        this.date = date;
        this.date = fechaFinal;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public int getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(int idJornada) {
        this.idJornada = idJornada;
    }

    public int getIdUusuario() {
        return idUusuario;
    }

    public void setIdUusuario(int idUusuario) {
        this.idUusuario = idUusuario;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}
