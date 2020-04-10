/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

/**
 *
 * @author invenio_110
 */
public class clsDatos {
    private int codigo;
    private String fecha;
    

   
    

   

    public clsDatos() {
    }

    
    public clsDatos(int codigo, String fecha) {
        this.codigo = codigo;
        this.fecha = fecha;
       
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
