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
    private String nome;
    private int contactoTlm;
    private Escalao equipa;
    //construtor
    public Treinador (String user, String passe, String nome, int tlm){
        super(user,passe);
	this.nome=nome;
        //user=String.valueOf(cipa);
        this.contactoTlm= tlm;
    }
    //Métodos seletores
    public String getNome() {
        return nome;
    }
		
    public int getContactoTlm() {
        return contactoTlm;
    }
	
	
    //Métodos modificadores
    public void setNome(String nome) {
        this.nome = nome;
    }
		
    public void setContactoTlm(int contactoTlm) {
        this.contactoTlm = contactoTlm;
    }

    public Escalao getEquipa() {
        return equipa;
    }

    public void setEquipa(Escalao equipa) {
        this.equipa = equipa;
    }
    
    
}