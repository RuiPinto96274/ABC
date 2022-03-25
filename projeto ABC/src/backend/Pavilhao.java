/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;



public class Pavilhao {
    private String id_pavilhao;
    private String nome;
    private String localizacao;

    //variavel que guarde os horarios em que está disponivel 

    //construtor

    public Pavilhao(String id_pavilhao, String nome, String localizacao) {
        this.id_pavilhao = id_pavilhao;
        this.nome = nome;
        this.localizacao = localizacao;
    }
   

    //Métodos seletores
    public String getLocal(){
        return localizacao;
    }

    public String getId_pavilhao() {
        return id_pavilhao;
    }

    public String getNome() {
        return nome;
    }
    
    //Métodos modificadores

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setId_pavilhao(String id_pavilhao) {
        this.id_pavilhao = id_pavilhao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}