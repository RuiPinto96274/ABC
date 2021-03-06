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
    private String nome;
    private int contactoTlm;
    
    //construtor
    public Colaborador (String user, String passe, String nome, int tlm){
        super(user,passe);
	//user=String.valueOf(cipa);
        this.contactoTlm= tlm;
        this.nome=nome;
    }
	//Métodos seletores
    public int getContactoTlm() {
        return contactoTlm;
    }
	    
    //Métodos modificadores
    public void setContactoTlm(int contactoTlm) {
        this.contactoTlm = contactoTlm;
    }   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Colaborador{" + ", nome=" + nome + ", contactoTlm=" + contactoTlm + '}';
    }
    
}