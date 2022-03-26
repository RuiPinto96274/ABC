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
    private String id_equipa;
    private String nome;
    private String genero;

    public Escalao(String id_escalao, String nome, String genero) {
        this.id_equipa = id_escalao;
        this.nome = nome;
        this.genero = genero;
    }
            
   
    
    /*
    void adicionarAtleta(Atleta a){
        if (a.getEscalao()!=null){
            lista_atletas.add(a);
        }
        
    }

    void removerAtleta(Atleta a){
        if(!lista_atletas.contains(a)){
            lista_atletas.remove(a);
        }
    }
*/
    public String getId_equipa() {
        return id_equipa;
    }
    
    
    public String getNome() {
        return nome;
    }


    public String getGenero() {
        return genero;
    }

    public void setId_equipa(String id_equipa) {
        this.id_equipa = id_equipa;
    }
    
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
}
