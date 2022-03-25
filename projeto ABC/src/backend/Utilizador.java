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
    private String username;
    private String password;
    private String nome;
  
    //construtor
    public Utilizador (String user, String passe, String nome){
        this.username=user;
        this.password=passe;
        this.nome=nome;
    }
    public Utilizador (){
        
    }
    //Métodos seletores
    public String getUsername(){
        return username;
    }
  
    public String getPassword(){
        return password;
    }

    public String getNome() {
        return nome;
    }
    
    //Método modificador
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString() {
        return "Utilizador{" + "username=" + username + ", password=" + password + '}';
    }   
}
