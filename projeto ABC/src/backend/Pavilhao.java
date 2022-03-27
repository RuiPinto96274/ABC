/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;



public class Pavilhao {
    private String idPavilhao;
    private String nome;
    private String morada;
    private String codigo_postal;

    //variavel que guarde os horarios em que está disponivel 

    //construtor
    public Pavilhao(String id_pavilhao, String nome, String localizacao, String cp) {
        this.idPavilhao = id_pavilhao;
        this.nome = nome;
        this.morada = localizacao;
        this.codigo_postal=cp;
    }
    
    public Pavilhao(String nome, String localizacao, String cp) {
        //this.idPavilhao = id_pavilhao;
        this.nome = nome;
        this.morada = localizacao;
        this.codigo_postal=cp;
    }
   
    public Pavilhao() {
        
    }

    //Métodos seletores
    public String getMorada(){
        return morada;
    }

    public String getIdPavilhao() {
        return idPavilhao;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }
    
    //Métodos modificadores

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setIdPavilhao(String idPavilhao) {
        this.idPavilhao = idPavilhao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}