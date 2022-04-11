/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


/**
 *
 * @author 
 */
public class Evento {
    //variaveis de instancia
    private String id_evento;
    private String nome;
    private String descricao;
    private Pavilhao pavilhao;   
    private LocalDate dia;
    private String hora;
    private Escalao escalao;
    private String tipo;
    
    //construtor
    public Evento (String evento, String nome, String descricao, Pavilhao pavilhao, LocalDate dia, String hora, Escalao esc, String tipo) {
	this.id_evento=evento;
        this.nome=nome;
        this.descricao=descricao;
        this.pavilhao=pavilhao;
        this.dia=dia;
        this.hora=hora;
        this.escalao=esc;
        this.tipo=tipo; 
    }
    
     public Evento (String nome, String descricao, Pavilhao pavilhao, LocalDate dia, String hora, Escalao esc, String tipo) {
        this.nome=nome;
        this.descricao=descricao;
        this.pavilhao=pavilhao;
        this.dia=dia;
        this.hora=hora;
        this.escalao=esc;
        this.tipo=tipo; 
    }
     
    public String getId_evento() {
        return id_evento;
    }

    public void setId_evento(String id_evento) {
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

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Escalao getEscalao(){
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
        return "Evento{" + "id_evento=" + id_evento + ", nome=" + nome + ", descricao=" + descricao + ", pavilhao=" + pavilhao + ", escalao=" + escalao + ", tipo=" + tipo + '}';
    }
    
    
}
