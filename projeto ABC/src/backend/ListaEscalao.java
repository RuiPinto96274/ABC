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
 * @author cataf
 */
public class ListaEscalao {
    //private ArrayList<Escalao> listaEscalao;
    
    public ListaEscalao(){
         //listaEscalao = listagemEscalao();
     }
     
     public class EscalaoNaoExistenteException extends Exception {
        public EscalaoNaoExistenteException() { }
        public EscalaoNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    public class EscalaoDuplicadoException extends Exception {
        public EscalaoDuplicadoException() { }
        public EscalaoDuplicadoException(String message) {
            super(message);
        }        
    }
    
    public Escalao getEscalao(String id) throws EscalaoNaoExistenteException {
        for (Escalao esc : listagemEscalao()){
                    if(esc.getId_escalao().equals(id)){
                        return esc;
                    }
                }
        return null;
    }
     
    public void adicionarEscalao(Escalao e) {
        try {
            Connection con;
            con=getConnection();
           
            String query = " insert into escalao (id_escalao, nome, genero)"
                    + " values (?, ?, ?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, e.getId_escalao());
            preparedStmt.setString(2, e.getNome());
            preparedStmt.setString(3, e.getGenero());
            preparedStmt.execute();
            con.close();
            
        } catch (Exception ex) {
            System.err.println("Erro ao adicionar um escalao! ");
            System.err.println(ex.getMessage());
        }
    }
     
    public void removerEscalao(Escalao e){
        try {
            Connection con;
            con=getConnection();
            
            String query = "delete from escalao where id_escalao = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, e.getId_escalao());
            preparedStmt.execute();
            con.close();
            
        } catch (Exception ex) {
            System.err.println("Erro ao remover um escalao! ");
            System.err.println(ex.getMessage());
        }
    }
     
    public ArrayList<Escalao> listagemEscalao(){
        ArrayList <Escalao> lista = new ArrayList<>();
        try {
            Connection con;
            con=getConnection();
            String query = "SELECT * FROM escalao";

            Statement st;
            ResultSet rs;

            st = con.createStatement();
            rs = st.executeQuery(query);
            Escalao escalao;

            while(rs.next()) {
                escalao = new Escalao(rs.getString("id_escalao"),rs.getString("nome"),rs.getString("genero"));
                lista.add(escalao);
            }
            con.close();
            return lista;

        }catch (Exception ex) {
            System.err.println("Erro a listar escaloes!");
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    
    
}
