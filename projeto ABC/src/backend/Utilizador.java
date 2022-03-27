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
public class Utilizador {
    //variaveis de instancia
    private String cipa;
    private String password;
  
    //construtor
    public Utilizador (String user, String passe){
        this.cipa=user;
        this.password=passe;
    }
    public Utilizador (){
        
    }
    //Métodos seletores
    public String getCipa(){
        return cipa;
    }
  
    public String getPassword(){
        return password;
    }

    
    //Método modificador
    public void setCipa(String cipa) {
        this.cipa = cipa;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Utilizador{" + "username=" + cipa + ", password=" + password + '}';
    }   
}
