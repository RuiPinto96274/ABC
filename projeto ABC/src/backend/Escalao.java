/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;

/**
 *
 * @author cataf
 */
public class Escalao {
    private String id_escalao;
    private String nome;
    private String genero;
    private ArrayList<Atleta> lista_atletas = new ArrayList();

    public Escalao(String id_escalao, String nome, String genero) {
        this.id_escalao = id_escalao;
        this.nome = nome;
        this.genero = genero;
    }
            
   
    
    /*
    void adicionarAtleta(Atleta a){
        if (a.getEscalao()!=null){
            lista_atletas.add(a);
        }
        
    }
*/
    void removerAtleta(Atleta a){
        if(!lista_atletas.contains(a)){
            lista_atletas.remove(a);
        }
    }

    public String getId_escalao() {
        return id_escalao;
    }
    
    
    public String getNome() {
        return nome;
    }

    public ArrayList<Atleta> getLista_atletas() {
        return lista_atletas;
    }

    public String getGenero() {
        return genero;
    }

    public void setId_escalao(String id_escalao) {
        this.id_escalao = id_escalao;
    }
    
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLista_atletas(ArrayList<Atleta> lista_atletas) {
        this.lista_atletas = lista_atletas;
    }
}
