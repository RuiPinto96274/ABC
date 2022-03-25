/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;


/**
 *
 * @author 
 */
public class Administrador extends Utilizador{
    private int contactoTlm;
    
    //construtor
    public Administrador(String user, String passe, String nome, int tlm){
      super(user,passe, nome);
      this.contactoTlm= tlm;    
    }

    public int getContactoTlm() {
        return contactoTlm;
    }

    public void setContactoTlm(int contactoTlm) {
        this.contactoTlm = contactoTlm;
    }
    
}
