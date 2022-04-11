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
import java.time.LocalDate;
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
                ListaEscalao listagemEscalao=new ListaEscalao();
                Escalao esc=listagemEscalao.getEscalao(String.valueOf(rs.getInt("Equipa_idEquipa")));
                Evento evento;
                
                ListaPavilhao listagemPavilhoes=new ListaPavilhao();
                Pavilhao pv=listagemPavilhoes.getPavilhao(String.valueOf(rs.getInt("Pavilhao_idPavilhao")));
            
                evento = new Evento(rs.getString("idEvento"),rs.getString("nome"),rs.getString("descricao"),pv,LocalDate.parse(rs.getString("dia")),rs.getString("hora"),esc,rs.getString("tipo"));
                listaEventos.add(evento);
            }
            con.close();
            return listaEventos;

        } catch (Exception ex) {
            System.err.println("Erro ao listar eventos! ");
            System.err.println(ex.getMessage());
        }  
        return null;
    }
    
     public void adicionarEventos(Evento e){
        try {
            Connection con;
            con=getConnection();
            String query = "INSERT INTO Evento (nome,descricao,Pavilhao_idPavilhao,dia,hora,Equipa_idEquipa,tipo) VALUES (?,?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1,e.getNome());
            ps.setString(2, e.getDescricao());
            ps.setString(3, e.getPavilhao().getIdPavilhao());
            ps.setObject(4, e.getDia());
            ps.setString(5, e.getHora());
            ps.setObject(6, e.getEscalao().getId_equipa());
            ps.setString(7, e.getTipo());
            
            ps.execute();
            con.close();
        } catch (Exception ex) {
            System.err.println("Erro ao listar eventos! ");
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
        return listagemEventos().size();
    }
    
    public void removerEvento(Evento evento){
        try {
            Connection con;
            con=getConnection();
            
            String query = "delete from Evento where idEvento = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, evento.getId_evento());

            preparedStmt.execute();
            con.close();
            
        } catch (Exception ex) {
            System.err.println("Erro ao remover um evento! ");
            System.err.println(ex.getMessage());
        }
    }
    
    public void alterarEvento(Evento evento){
        try {
            Connection con;
            con=getConnection();
            String query = "update Evento set nome=? , descricao=?,  Pavilhao_idPavilhao=?,  dia=?, hora=?, Equipa_idEquipa=?, tipo=?  where idEvento= ?";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, evento.getNome());
            preparedStmt.setString(2, evento.getDescricao());
            preparedStmt.setString(3, evento.getPavilhao().getIdPavilhao());
            preparedStmt.setObject(4, evento.getDia());
            preparedStmt.setString(5, evento.getHora());
            preparedStmt.setString(6, evento.getEscalao().getId_equipa());
            preparedStmt.setString(7, evento.getTipo());
            preparedStmt.setString(8, evento.getId_evento());
            preparedStmt.execute();
            con.close();

        } catch (Exception ex) {
            System.err.println("Erro ao alterar um evento! ");
            System.err.println(ex.getMessage());
        }
    }

    public boolean existe(String id_evento){
       for(int i=0; i<listagemEventos().size(); i++){
           if(listagemEventos().get(i).getId_evento()==id_evento){
               return true;
           }
       } 
       return false;
     }
    

    public Evento getIdEvento(String id_evento)throws ListaEventos.EventoNaoExistenteException{
        for (Evento evento : listagemEventos()){
            if (evento.getId_evento()==id_evento){
                return evento;             
            }
        }
        throw new ListaEventos.EventoNaoExistenteException("O evento não existe na lista");     
   }
   
}

