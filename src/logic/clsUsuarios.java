/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author INVENIO122
 */
public class clsUsuarios {
    private String nombre;
      private String usuario;
        private String password;
          private String email;
        private String telefono;

    public clsUsuarios() {
    }

    public clsUsuarios(String nombre, String usuario, String password, String email, String telefono) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
        this.email = email;
        this.telefono = telefono;
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
        
    
        
        
        
}
