/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;


import java.time.LocalDate;

/**
 *
 * @author 
 */
public class Atleta extends Utilizador{
    //variaveis de instancia
    private int cipa;
    private LocalDate dataNasc;
    private Escalao escalao;
    private int contactoTlm;
   
    //construtor
    public Atleta (String user, String pass, int cipa, String nome, LocalDate data_nasc, Escalao esc, int tlm) {
        super(user, pass, nome); //cod=cipa
	this.cipa=cipa;
        user=Integer.toString(cipa);
        this.dataNasc=data_nasc;
	this.escalao=esc;
        this.contactoTlm= tlm;
    }
    public Atleta (){
        
    }
    
    //Métodos seletores
	public int getCipa() {
        return cipa;
    }
	
    public LocalDate getDataNasc() {
        return dataNasc;
    }
	
    public Escalao getEscalao() {
        return escalao;
    }
	
    public int getContactoTlm() {
        return contactoTlm;
    }
    
    //Métodos modificadores
    public void setCipa(int cipa) {
        this.cipa = cipa;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }
	
public void setEscalao(Escalao escalao) {
        this.escalao = escalao;
    }
	
    public void setContactoTlm(int contactoTlm) {
        this.contactoTlm = contactoTlm;
    }

    @Override
    public String toString() {
        return "Atleta{" + "cipa=" + cipa + ", dataNasc=" + dataNasc + ", escalao=" + escalao + ", contactoTlm=" + contactoTlm + '}';
    }

    
}
