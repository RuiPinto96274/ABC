/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import static frontend.Iniciar.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author 
 */
public class ListaPavilhao {
     //private ArrayList<Pavilhao> listaPavilhoes;
     
     public ListaPavilhao(){
         //this.listaPavilhoes = listagemPavilhoes();
     }
     
     public Pavilhao getPavilhao(String id){
        for (Pavilhao pv : listagemPavilhoes()){
                    if(pv.getIdPavilhao().equals(id)){
                        return pv;
                    }
                }
        return null;
    }
        
     public void adicionarPavilhao(Pavilhao p) {
        try {
            Connection con;
            con=getConnection();
           
            String query = " insert into Pavilhao (nome, morada, codigo_postal)"
                    + " values (?, ?, ?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            //preparedStmt.setString(1, p.getIdPavilhao());
            preparedStmt.setString(1, p.getNome());
            preparedStmt.setString(2, p.getMorada());
            preparedStmt.setString(3, p.getCodigo_postal());
            preparedStmt.execute();
            con.close();
            
        } catch (Exception ex) {
            System.err.println("Erro ao adicionar um pavilhao! ");
            System.err.println(ex.getMessage());
        }
    }

     public void alterarPavilhao(Pavilhao p, String id, String nome, String morada, String cod) {
        try {
            Connection con;
            con=getConnection();
            String query = "update Pavilhao set nome=? , morada=?, codigo_postal=? where idPavilhao= ?";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            //preparedStmt.setString(1, p.getIdPavilhao());
            preparedStmt.setString(1, nome);
            preparedStmt.setString(2, morada);
            preparedStmt.setString(3, cod);
            preparedStmt.setString(4, p.getIdPavilhao());
            preparedStmt.execute();
            con.close();
            
        } catch (Exception ex) {
            System.err.println("Erro ao alterar um pavilhao! ");
            System.err.println(ex.getMessage());
        }
    }
     
     public void removerPavilhao(Pavilhao p){
        try {
            Connection con;
            con=getConnection();
            
            String query = "delete from Pavilhao where idPavilhao = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, p.getIdPavilhao());
            preparedStmt.execute();
            con.close();
            
        } catch (Exception ex) {
            System.err.println("Erro ao remover um pavilhao! ");
            System.err.println(ex.getMessage());
        }
    }
     
     public ArrayList<Pavilhao> listagemPavilhoes(){
        ArrayList <Pavilhao> listaPavilhoes = new ArrayList<>();
        try {
            Connection con;
            con=getConnection();
            String query = "SELECT * FROM Pavilhao";

            Statement st;
            ResultSet rs;

            st = con.createStatement();
            rs = st.executeQuery(query);
            Pavilhao pavilhao;

            while(rs.next()) {
                pavilhao = new Pavilhao(rs.getString("idPavilhao"),rs.getString("nome"),rs.getString("morada"), rs.getString("codigo_postal"));
                listaPavilhoes.add(pavilhao);
            }

            return listaPavilhoes;
        } catch (Exception ex) {
            System.err.println("Erro a listar pavilhoes!");
            System.err.println(ex.getMessage());
        }
        return null;
    }
     
    public int size() {
        return listagemPavilhoes().size();
    }
}
