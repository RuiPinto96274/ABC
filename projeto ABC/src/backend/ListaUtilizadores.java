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
                    if(a.getCipa().equals(user)){
                        return a;
                    }
                }
        return null;
    }
	
    public Colaborador getColaborador(String user) throws UtilizadorNaoExistenteException {
        for (Colaborador c : listagemColaboradores()){
                    if(c.getCipa().equals(user)){
                        return c;
                    }
                }
        return null;
    }
    
    public Administrador getAdmin(String user) throws UtilizadorNaoExistenteException {
        for (Administrador a : listagemAdmin()){
                    if(a.getCipa().equals(user)){
                        return a;
                    }
                }
        return null;
    }
    
    public Treinador getTreinador(String user) throws UtilizadorNaoExistenteException {
        for (Treinador t : listagemTreinadores()){
                    if(t.getCipa().equals(user)){
                        return t;
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
            String query = "SELECT * FROM Treinador";

            Statement st;
            ResultSet rs;

            st = con.createStatement();
            rs = st.executeQuery(query);
            Treinador treinador;

            while(rs.next()){ 
                treinador = new Treinador(rs.getString("cipa"),rs.getString("pass"),rs.getString("nome"),Integer.parseInt(rs.getString("contacto")));
                ListaEscalao lista= new ListaEscalao();
                Escalao esc = lista.getEscalao(rs.getString("Equipa_idEquipa"));
                treinador.setEquipa(esc);
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
           
            String query = " insert into Atleta (cipa, nome, password, data_nasc, contacto)"
                    + " values (?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, a.getCipa());
            preparedStmt.setString(2, a.getNome());
            preparedStmt.setString(3, a.getPassword());
            preparedStmt.setObject(4, a.getDataNasc()); 
            preparedStmt.setInt(5, a.getContactoTlm());
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
            
            String query = "delete from Atleta where cipa = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, a.getCipa());

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
            String query = "SELECT * FROM Atleta";

            Statement st;
            ResultSet rs;

            st = con.createStatement();
            rs = st.executeQuery(query);
            Atleta atleta;

            while(rs.next()) {
                atleta = new Atleta(rs.getString("cipa"),rs.getString("nome"), rs.getString("password"), LocalDate.parse(rs.getString("data_nasc")), Integer.parseInt(rs.getString("contacto")));
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
           
            String query = " insert into Colaborador (pass, cipa, nome, tlm)"
                    + " values (?, ?, ?, ?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            //preparedStmt.setString(1, c.getUsername());
            preparedStmt.setString(1, c.getPassword());
            preparedStmt.setString(2, c.getCipa());
            preparedStmt.setString(3, c.getNome());
            preparedStmt.setInt(4, c.getContactoTlm());
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
            
            String query = "delete from Colaborador where cipa = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, c.getCipa());

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
            String query = "SELECT * FROM Colaborador";

            Statement st;
            ResultSet rs;

            st = con.createStatement();
            rs = st.executeQuery(query);
            Colaborador colab;

            while(rs.next()) {
                colab= new Colaborador(rs.getString("cipa"),rs.getString("pass"), rs.getString("nome"), Integer.parseInt(rs.getString("tlm")));
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
            String query = "SELECT * FROM Administrador";

            Statement st;
            ResultSet rs;

            st = con.createStatement();
            rs = st.executeQuery(query);
            Administrador admin;

            while(rs.next()) {
                admin= new Administrador(rs.getString("username"),rs.getString("pass"));
                listaAdmin.add(admin);               
            }

            return listaAdmin;

        } catch (Exception ex) {
            System.err.println("Erro ao listar os admin! ");
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public void alterarAdmin(Administrador a) {
        try {
            Connection con;
            con=getConnection();
            String query = "update Administrador set pass=?  where username= ?";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, a.getPassword());
            preparedStmt.setString(2, a.getCipa());
            preparedStmt.execute();
            con.close();

        } catch (Exception ex) {
            System.err.println("Erro ao alterar um admin! ");
            System.err.println(ex.getMessage());
        }
    }
    
    public void adicionarTreinador(Treinador t) {
        try {
            Connection con;
            con=getConnection();
           
            String query = " insert into Treinador (cipa, nome, pass, contacto)"
                    + " values (?, ?, ?, ?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, t.getCipa());
            preparedStmt.setString(2, t.getNome());
            preparedStmt.setString(3, t.getPassword());
            preparedStmt.setInt(4, t.getContactoTlm());
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
            
            String query = "delete from Treinador where cipa = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, t.getCipa());
            preparedStmt.execute();
            con.close();
            
        } catch (Exception ex) {
            System.err.println("Erro ao remover treinador!");
            System.err.println(ex.getMessage());
        }
    }
    
    public void alterarTreinadorComEscalao(Treinador t) {
        try {
            Connection con;
            con=getConnection();
            String query = "update Treinador set nome=? , pass=?,  contacto=?,  Equipa_idEquipa=? where cipa= ?";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, t.getNome());
            preparedStmt.setString(2, t.getPassword());
            preparedStmt.setInt(3, t.getContactoTlm());
            preparedStmt.setString(4, t.getEquipa().getId_equipa());
            preparedStmt.setString(5, t.getCipa());
            preparedStmt.execute();
            con.close();

        } catch (Exception ex) {
            System.err.println("Erro ao alterar um treinador! ");
            System.err.println(ex.getMessage());
        }
    } 
    
    public void alterarTreinadorSemEscalao(Treinador t) {
        try {
            Connection con;
            con=getConnection();
            String query = "update Treinador set nome=? , pass=?,  contacto=? where cipa= ?";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, t.getNome());
            preparedStmt.setString(2, t.getPassword());
            preparedStmt.setInt(3, t.getContactoTlm());
            preparedStmt.setString(4, t.getCipa());
            preparedStmt.execute();
            con.close();

        } catch (Exception ex) {
            System.err.println("Erro ao alterar um treinador sem escalao! ");
            System.err.println(ex.getMessage());
        }
    }
    
    public void associarEscalao(Treinador t, Escalao e) {
        try {
            Connection con;
            con=getConnection();
            String query = "update Treinador set Equipa_idEquipa=? where cipa= ?";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, e.getId_equipa());
            preparedStmt.setString(2, t.getCipa());
            preparedStmt.execute();
            con.close();

        } catch (Exception ex) {
            System.err.println("Erro ao associar um escalao a treinador! ");
            System.err.println(ex.getMessage());
        }
    }
}