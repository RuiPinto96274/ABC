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
public class Colaborador extends Utilizador{
    //variaveis de instancia
    private int cipa;
    private int contactoTlm;
    
    //construtor
    public Colaborador (String user, String passe, String nome, int cipa, int tlm){
        super(user,passe,nome);
	this.cipa=cipa;
        this.contactoTlm= tlm;
    }
	//Métodos seletores
    public int getCipa() {
        return cipa;
    }
	
    public int getContactoTlm() {
        return contactoTlm;
    }
	    
    //Métodos modificadores
    public void setCipa(int cipa) {
        this.cipa = cipa;
    }
	
    public void setContactoTlm(int contactoTlm) {
        this.contactoTlm = contactoTlm;
    }   
}