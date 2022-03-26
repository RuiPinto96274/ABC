/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.time.LocalDateTime;
import java.util.Date;



/**
 *
 * @author 
 */
public class Evento {
    //variaveis de instancia
   /* private int id_evento;
    private String nome;
    private String descricao;
    private Pavilhao pavilhao;   
    private LocalDateTime dia_hora;
    private Escalao escalao;
    private String tipo;*/
    
    private int id_evento;
    private String local;
    private Date dia;
    private LocalDateTime hora;
    private String escalao;
 
    //construtor
    public Evento (int evento, String local,Date dia, String esc/*int evento, String nome, String descricao, Pavilhao pavilhao, LocalDateTime dia, Escalao esc, String tipo*/) {
	/*this.id_evento=evento;
        this.nome=nome;
        this.descricao=descricao;
        this.pavilhao=pavilhao;
        this.dia_hora=dia;
        this.escalao=esc;
        this.tipo=tipo;*/
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
        /*
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
    }*/
/*
    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pavilhao getPavilhao() {
        return pavilhao;
    }

    public void setPavilhao(Pavilhao pavilhao) {
        this.pavilhao = pavilhao;
    }

    public LocalDateTime getDia_hora() {
        return dia_hora;
    }

    public void setDia_hora(LocalDateTime dia_hora) {
        this.dia_hora = dia_hora;
    }

    public Escalao getEscalao() {
        return escalao;
    }

    public void setEscalao(Escalao escalao) {
        this.escalao = escalao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Evento{" + "id_evento=" + id_evento + ", nome=" + nome + ", descricao=" + descricao + ", pavilhao=" + pavilhao + ", dia_hora=" + dia_hora + ", escalao=" + escalao + ", tipo=" + tipo + '}';
    }
    
    */
}
