/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic;

/**
 *
 * @author Hp
 */


/**
 *
 * @author Hp
 */
public class clsLogin{
    //Atributos de la clase
   
    private String email;
    private String password;
    
    
    
    //Constructor default
    public clsLogin() {
        
    }
    //Constructor parámetros
    public clsLogin( String email, String pass) {
        
        this.email = email;
        this.password = pass;
        
    }
    //Getter and Setter
  
 /* public int getId() {
        return id;
    }

    public void setid(int Id) {
        this.id = Id;
    }*/
    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getPass() {
        return password;
    }

    public void setPass(String Pass) {
        this.password = Pass;
    }
}
