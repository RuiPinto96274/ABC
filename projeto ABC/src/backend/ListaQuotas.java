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
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author cataf
 */
public class ListaQuotas {
    private ArrayList <Quota> lista; 
    
    public ListaQuotas(){
        lista= new ArrayList();
    }
    
     public ArrayList<Quota> listagemQuotas(){
        ArrayList <Quota> listaQuotas = new ArrayList<>();
        try {
            Connection con;
            con=getConnection();
            String query = "SELECT * FROM quotas";

            Statement st;
            ResultSet rs;

            st = con.createStatement();
            rs = st.executeQuery(query);

            while(rs.next()){ 
                Quota quota;
                quota = new Quota(Integer.parseInt(rs.getString("id_quota")),rs.getString("username"),rs.getString("pagou"), LocalDate.parse(rs.getString("data_pag")));
                listaQuotas.add(quota);
            }
            con.close();
            return listaQuotas;

        } catch (Exception ex) {
            System.err.println("Erro ao listar quotas! ");
            System.err.println(ex.getMessage());
        }  
        return null;
    }
    
     public void guardarQuota(Atleta a, LocalDate data){
        try {
            Connection con;
            con=getConnection();
            String query = "INSERT INTO quotas (username, data_pag, pagou) VALUES (?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1,a.getUsername());
            ps.setObject(2, data);
            ps.setObject(3, 'Y');
           
            ps.executeUpdate();            

        } catch (Exception ex) {
            System.err.println("Erro ao inserir uma quota na tabela! ");
            System.err.println(ex.getMessage());
        }  
    }
}
