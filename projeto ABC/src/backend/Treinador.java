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
public class Treinador extends Utilizador{
    //variaveis de instancia
    private int cipa;
    private String nome;
    private int contactoTlm;
    //construtor
    public Treinador (String user, String passe, int cipa, String nome, int tlm){
        super(user,passe, nome);
	this.cipa=cipa;
	this.nome=nome;
        this.contactoTlm= tlm;
    }
    //Métodos seletores
    public int getCipa() {
        return cipa;
    }
	
    public String getNome() {
        return nome;
    }
		
    public int getContactoTlm() {
        return contactoTlm;
    }
	
	
    //Métodos modificadores
    public void setCipa(int cipa) {
        this.cipa = cipa;
    }
	
    public void setNome(String nome) {
        this.nome = nome;
    }
		
    public void setContactoTlm(int contactoTlm) {
        this.contactoTlm = contactoTlm;
    }
}