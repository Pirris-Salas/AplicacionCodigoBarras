/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;


public class clsEmpleados {
   private int idUsuario;
    private String nombre;
    private String usuario;
    private String password;
    private int tipo;
    private String email;
    private String telefono;
    private String apellido; 

    public clsEmpleados(int idUsuario, String nombre, String usuario, String password, int tipo, String email, String telefono, String apellido) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
        this.tipo = tipo;
        this.email = email;
        this.telefono = telefono;
        this.apellido = apellido;
    }
    public clsEmpleados() {
        this.idUsuario = 0;
        this.nombre = "";
        this.usuario = "";
        this.password = "";
        this.tipo = 0;
        this.email = "";
        this.telefono = "";
        this.apellido = "";
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
