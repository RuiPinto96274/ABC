/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import static frontend.Iniciar.getConnection;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author
 */
public class ListaEventos {
    //variaveis de instancia
    private ArrayList <Evento> listaEventos; 
        
    //construtor
    public ListaEventos(){
        listaEventos= new ArrayList();
    }
    
    public Evento getEvento(String id){
        
    }
    
    public ArrayList<Evento> listagemEventos(){
        ArrayList <Evento> listaEventos = new ArrayList<>();
        try {
            Connection con;
            con=getConnection();
            String query = "SELECT * FROM Evento";

            Statement st;
            ResultSet rs;

            st = con.createStatement();
            rs = st.executeQuery(query);

            while(rs.next()){ 
                Evento evento;
                evento = new Evento(0,rs.getString("localizacao"),rs.getDate("dia"), rs.getString("escalao"));
                listaEventos.add(evento);
            }
            con.close();
            return listaEventos;

        } catch (Exception ex) {
            System.err.println("Erro ao listar treinadores! ");
            System.err.println(ex.getMessage());
        }  
        return null;
    }
    
     public void adicionarEventos(String local, String escalao){
        try {
            Connection con;
            con=getConnection();
            String query = "INSERT INTO Evento (localizacao,escalao) VALUES (?,?)";
            
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1,local);
            ps.setString(2, escalao);
            
            ps.executeUpdate();

            

            Statement st;

            st = con.createStatement();
            

        } catch (Exception ex) {
            System.err.println("Erro ao listar treinadores! ");
            System.err.println(ex.getMessage());
        }  
    }
    
    
    
    //exceções
    public class EventoNaoExistenteException extends Exception {
        public EventoNaoExistenteException(){ }
        public EventoNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    public class EventoDuplicadoException extends Exception {
        public EventoDuplicadoException() { }
        public EventoDuplicadoException(String message) {
            super(message);
        }        
    }
    
    //Método seletor    
    public int length(){
        return listaEventos.size();
    }


    
    public void removerEvento(Evento evento){
        //listaEventos.remove(evento);
        
    }
    
    public void alterarEvento(Evento evento){
        
    }

    public boolean existe(int id_evento){
       for(int i=0; i<listaEventos.size(); i++){
           if(listaEventos.get(i).getIdEvento()==id_evento){
               return true;
           }
       } 
       return false;
     }
    

    public Evento getIdEvento(int id_evento)throws ListaEventos.EventoNaoExistenteException{
        for (Evento evento : listaEventos){
            if (evento.getIdEvento()==id_evento){
                return evento;             
            }
        }
        throw new ListaEventos.EventoNaoExistenteException("O evento não existe na lista");     
   }
   
}

