/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author 
 */
public class Evento {
    //variaveis de instancia
    private int id_evento;
    private String local;
    private Date dia;
    private LocalDateTime hora;
    private String escalao;

 
    //construtor
    public Evento (int evento, String local,Date dia, String esc) {
	this.id_evento=evento;
        this.local=local;
        this.dia=dia;
	this.escalao=esc;
   
    }
    
    //Métodos seletores
	public int getIdEvento(){
        return id_evento;
    }
	public String getLocal(){
        return local;
    }
    
    public Date getHora(){
        return dia;
    }
	
    public String getEscalao(){
        return escalao;
    }
	
    //Métodos modificadores	
	public void setlocal(int id_evento){
        this.id_evento = id_evento;
    }
	
    public void setlocal(String local){
        this.local = local;
    }

    public void setHora(LocalDateTime hora){
        this.hora = hora;
    }
	
	public void setEscalao(String escalao){
        this.escalao = escalao;
    }
	
    @Override
    public String toString() {
        return "Evento{" + "local=" + local +", dia=" + dia + ", hora=" + hora + ", escalao=" + escalao + '}';
    }
}
