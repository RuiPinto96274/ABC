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
     private ArrayList<Pavilhao> listaPavilhoes;
     
     public ListaPavilhao(){
         this.listaPavilhoes = listagemPavilhoes();
     }
     
     public void adicionarPavilhao(Pavilhao p) {
        try {
            Connection con;
            con=getConnection();
           
            String query = " insert into pavilhao (id_pavilhao, nome, localizacao)"
                    + " values (?, ?, ?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, p.getId_pavilhao());
            preparedStmt.setString(2, p.getNome());
            preparedStmt.setString(3, p.getLocal());
            preparedStmt.execute();
            con.close();
            
        } catch (Exception ex) {
            System.err.println("Erro ao adicionar um pavilhao! ");
            System.err.println(ex.getMessage());
        }
    }
     
     public void removerPavilhao(Pavilhao p){
        try {
            Connection con;
            con=getConnection();
            
            String query = "delete from pavilhao where id_pavilhao = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, p.getId_pavilhao());
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
            String query = "SELECT * FROM pavilhao";

            Statement st;
            ResultSet rs;

            st = con.createStatement();
            rs = st.executeQuery(query);
            Pavilhao pavilhao;

            while(rs.next()) {
                pavilhao = new Pavilhao(rs.getString("id_pavilhao"),rs.getString("nome"),rs.getString("localizacao"));
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
        return listaPavilhoes.size();
    }
}
