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
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;

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
            String query = "SELECT * FROM Quota";

            Statement st;
            ResultSet rs;

            st = con.createStatement();
            rs = st.executeQuery(query);

            while(rs.next()){ 
                Quota quota;
                quota = new Quota(Integer.parseInt(rs.getString("idQuota")),rs.getString("Atleta_cipa"),rs.getString("estado"), LocalDate.parse(rs.getString("data")));
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

     public ArrayList<Quota> listagemPorAtleta(Atleta a){
         //ArrayList <Quota> listaQuotas = listagemQuotas();
         ArrayList <Quota> lista = new ArrayList<>();
         for(Quota q : listagemQuotas()){
             if(q.getUsername().equals(a.getCipa())){
                 lista.add(q);
             }
         }
         return lista;
     }
     
     public Quota procurarQuotaAtleta(Atleta a, int m, int y){
        Calendar c_ini = Calendar.getInstance();
        c_ini.set(y,m-1,1);
        LocalDate data_ini = LocalDate.ofInstant(c_ini.toInstant(), ZoneId.systemDefault());
        Calendar c_fim = Calendar.getInstance();
        c_fim.set(y, m-1,29);
        c_fim.set(y, m-1, c_fim.getActualMaximum(Calendar.DAY_OF_MONTH));
        LocalDate data_fim = LocalDate.ofInstant(c_fim.toInstant(), ZoneId.systemDefault());

         for(Quota q: listagemPorAtleta(a)){
             if(q.getData().isAfter(data_ini) && q.getData().isBefore(data_fim)){
                 return q;
             }
         }
         return null;
     }
     
     public void guardarQuota(Quota q){
        try {
            Connection con;
            con=getConnection();
            String query = "INSERT INTO Quota (idQuota, Atleta_cipa, estado, data) VALUES (?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1,String.valueOf(q.getId_quota()));
            ps.setString(2,q.getUsername());
            ps.setString(3, "1");
             ps.setObject(4, q.getData());
           
            ps.executeUpdate();            

        } catch (Exception ex) {
            System.err.println("Erro ao inserir uma quota na tabela! ");
            System.err.println(ex.getMessage());
        }  
    }
}
