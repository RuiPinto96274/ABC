/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import static frontend.Iniciar.getConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.PreparedStatement;

/**
 *
 * @author 
 */
public class ListaUtilizadores {
    //variaveis de instancia
    private HashMap<String, Utilizador> listaUtilizadores;

    //construtor
    public ListaUtilizadores() {
        listaUtilizadores = new HashMap<>();        
    }
    
    //exceções
    public class UtilizadorNaoExistenteException extends Exception {
        public UtilizadorNaoExistenteException() { }
        public UtilizadorNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    public class UtilizadorDuplicadoException extends Exception {
        public UtilizadorDuplicadoException() { }
        public UtilizadorDuplicadoException(String message) {
            super(message);
        }        
    }
    
    //Método seletor
    public HashMap<String, Utilizador> getListaUtilizadores() {
        return listaUtilizadores;
    }

    public boolean existe(String username) {
        return listaUtilizadores.containsKey(username);
    }
    
    public int size() {
        return listaUtilizadores.size();
    }
    /*
    public void removerUtilizador(String username) {
        listaUtilizadores.remove(username);
    }
    */
    public Utilizador getUtilizador(String username) throws UtilizadorNaoExistenteException {
        if (listaUtilizadores.containsKey(username)){
            return listaUtilizadores.get(username);
        }else{
            throw new UtilizadorNaoExistenteException("O utilizador nao existe na lista");
        }
    }

    public Atleta getAtleta(String user) throws UtilizadorNaoExistenteException {
        for (Atleta a : listagemAtletas()){
                    if(a.getUsername().equals(user)){
                        return a;
                    }
                }
        return null;
    }
	
    public Colaborador getColaborador(String user) throws UtilizadorNaoExistenteException {
        for (Colaborador c : listagemColaboradores()){
                    if(c.getUsername().equals(user)){
                        return c;
                    }
                }
        return null;
    }
    
    public Administrador getAdmin(String user) throws UtilizadorNaoExistenteException {
        for (Administrador a : listagemAdmin()){
                    if(a.getUsername().equals(user)){
                        return a;
                    }
                }
        return null;
    }
    
    public ArrayList<Utilizador> listagemUtilizadores() {
        return new ArrayList<>(listaUtilizadores.values());
    }
    
    public ArrayList<Treinador> listagemTreinadores(){
        ArrayList <Treinador> listaTreinadores = new ArrayList<>();
        try {
            Connection con;
            con=getConnection();
            String query = "SELECT * FROM treinador";

            Statement st;
            ResultSet rs;

            st = con.createStatement();
            rs = st.executeQuery(query);
            Treinador treinador;

            while(rs.next()){ 
                treinador = new Treinador(rs.getString("username"),rs.getString("pass"),Integer.parseInt(rs.getString("cipa")),rs.getString("nome"),Integer.parseInt(rs.getString("tlm")));
                listaTreinadores.add(treinador);
            }
            con.close();
            return listaTreinadores;

        } catch (Exception ex) {
            System.err.println("Erro ao listar treinadores! ");
            System.err.println(ex.getMessage());
        }  
        return null;
    }
    
    public void adicionarAtleta(Atleta a) {
        try {
            Connection con;
            con=getConnection();
           
            String query = " insert into atleta (username, pass, cipa, nome, ano_nasc, id_escalao, tlm)"
                    + " values (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, a.getUsername());
            preparedStmt.setString(2, a.getPassword());
            preparedStmt.setInt(3, a.getCipa());
            preparedStmt.setString(4, a.getNome());
            preparedStmt.setObject(5, a.getDataNasc()); 
            preparedStmt.setString(6, a.getEscalao().getId_escalao());
            preparedStmt.setInt(7, a.getContactoTlm());
            preparedStmt.execute();
            con.close();
            
        } catch (Exception ex) {
            System.err.println("Got an exception, when trying to add an athlete! ");
            System.err.println(ex.getMessage());
        }
    }
    
    public void removerAtleta(Atleta a){
        try {
            Connection con;
            con=getConnection();
            
            String query = "delete from atleta where username = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, a.getUsername());

            preparedStmt.execute();
            con.close();
            
        } catch (Exception ex) {
            System.err.println("Got an exception when trying to remove an athlete! ");
            System.err.println(ex.getMessage());
        }
    }
    
    public ArrayList<Atleta> listagemAtletas(){
        ArrayList <Atleta> listaAtletas = new ArrayList<>();
        try {
            Connection con;
            con=getConnection();
            String query = "SELECT * FROM atleta";

            Statement st;
            ResultSet rs;

            st = con.createStatement();
            rs = st.executeQuery(query);
            Atleta atleta;

            while(rs.next()) {
                ListaEscalao lista_esc = new ListaEscalao();
                Escalao esc= lista_esc.getEscalao(rs.getString("id_escalao"));
                atleta = new Atleta(rs.getString("username"),rs.getString("pass"),Integer.parseInt(rs.getString("cipa")),rs.getString("nome"),LocalDate.parse(rs.getString("ano_nasc")), esc, Integer.parseInt(rs.getString("tlm")));
                listaAtletas.add(atleta);
            }
            con.close();
            return listaAtletas;

        } catch (Exception ex) {
            System.err.println("Got an exception ao carregar tabela atletas! ");
            System.err.println(ex.getMessage());
        }
        
        return null;
    }
    
        public void adicionarColaborador(Colaborador c) {
        try {
            Connection con;
            con=getConnection();
           
            String query = " insert into colaborador (username, pass, cipa, nome, tlm)"
                    + " values (?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, c.getUsername());
            preparedStmt.setString(2, c.getPassword());
            preparedStmt.setInt(3, c.getCipa());
            preparedStmt.setString(4, c.getNome());
            preparedStmt.setInt(5, c.getContactoTlm());
            preparedStmt.execute();
            con.close();
            
        } catch (Exception ex) {
            System.err.println("Got an exception, when trying to add um colaborador! ");
            System.err.println(ex.getMessage());
        }
    }
    
    public void removerColaborador(Colaborador c){
        try {
            Connection con;
            con=getConnection();
            
            String query = "delete from colaborador where username = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, c.getUsername());

            preparedStmt.execute();
            con.close();
            
        } catch (Exception ex) {
            System.err.println("Got an exception when trying to remove um colaborador! ");
            System.err.println(ex.getMessage());
        }
    }
    
    public ArrayList<Colaborador> listagemColaboradores(){
        ArrayList <Colaborador> listaColaboradores = new ArrayList<>();
        try {
            Connection con;
            con=getConnection();
            String query = "SELECT * FROM colaborador";

            Statement st;
            ResultSet rs;

            st = con.createStatement();
            rs = st.executeQuery(query);
            Colaborador colab;

            while(rs.next()) {
                colab= new Colaborador(rs.getString("username"),rs.getString("pass"),rs.getString("nome"),Integer.parseInt(rs.getString("cipa")), Integer.parseInt(rs.getString("tlm")));
                listaColaboradores.add(colab);               
            }

            return listaColaboradores;

        } catch (Exception ex) {
            System.err.println("Erro ao listar colaboradores ");
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public ArrayList<Administrador> listagemAdmin(){
        ArrayList <Administrador> listaAdmin = new ArrayList<>();
        try {
            Connection con;
            con=getConnection();
            String query = "SELECT * FROM administrador";

            Statement st;
            ResultSet rs;

            st = con.createStatement();
            rs = st.executeQuery(query);
            Administrador admin;

            while(rs.next()) {
                admin= new Administrador(rs.getString("username"),rs.getString("pass"),rs.getString("nome"), Integer.parseInt(rs.getString("tlm")));
                listaAdmin.add(admin);               
            }

            return listaAdmin;

        } catch (Exception ex) {
            System.err.println("Erro ao listar os admin! ");
            System.err.println(ex.getMessage());
        }
        return null;
    }
    	
    public void adicionarTreinador(Treinador t) {
        try {
            Connection con;
            con=getConnection();
           
            String query = " insert into treinador (username, pass, cipa, nome, tlm)"
                    + " values (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, t.getUsername());
            preparedStmt.setString(2, t.getPassword());
            preparedStmt.setInt(3, t.getCipa());
            preparedStmt.setString(4, t.getNome());
            preparedStmt.setInt(5, t.getContactoTlm());
            preparedStmt.execute();
            con.close();
            
        } catch (Exception ex) {
            System.err.println("Erro ao adicionar treinador!");
            System.err.println(ex.getMessage());
        }
    }
    
    public void removerTreinador(Treinador t){
        try {
            Connection con;
            con=getConnection();
            
            String query = "delete from treinador where username = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, t.getUsername());
            preparedStmt.execute();
            con.close();
            
        } catch (Exception ex) {
            System.err.println("Erro ao remover treinador!");
            System.err.println(ex.getMessage());
        }
    }
}