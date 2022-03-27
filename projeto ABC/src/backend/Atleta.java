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
    private String nome;
    private LocalDate dataNasc;
    private int contactoTlm;
   
    //construtor
    public Atleta (String user, String nome, String pass, LocalDate data_nasc, int tlm) {
        super(user, pass);
	//user=String.valueOf(cipa);
        //cipa=Integer.parseInt(user);
        this.nome=nome;
        this.dataNasc=data_nasc;
        this.contactoTlm= tlm;
    }
    public Atleta (){
        
    }
    //Métodos seletores
    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public int getContactoTlm() {
        return contactoTlm;
    }
    
    //Métodos modificadores
    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

	
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
        return "Atleta{" + ", nome=" + nome + ", dataNasc=" + dataNasc + ", contactoTlm=" + contactoTlm + '}';
    }


    
}
