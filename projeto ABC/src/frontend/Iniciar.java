/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.ListaEventos;
import backend.ListaUtilizadores;
//import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;



public class Iniciar {
        public static void main(String[] args) throws ListaUtilizadores.UtilizadorDuplicadoException, ClassNotFoundException, ListaEventos.EventoDuplicadoException {
           Login pg = new Login();               
           pg.setVisible(true);
           
}
        
          
    public static Connection getConnection() throws Exception{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String myURL = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11479895?zeroDateTimeBehavior=CONVERT_TO_NULL";
            Connection con = DriverManager.getConnection(myURL, "sql11479895", "uHUGltPrNj");
            return con;
        } catch(Exception e){System.out.println(e);}
            System.err.println("Erro ao conectar!");
            return null;
    }
    /*
        public static Connection getConnection() throws Exception{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String myURL = "jdbc:mysql://mysql-projetoabc-carolinabarreiro2504-9830.aivencloud.com:28599/defaultdb?zeroDateTimeBehavior=CONVERT_TO_NULL";
            Connection con = DriverManager.getConnection(myURL, "avnadmin", "AVNS_Jp8ez-CPvq0CBt7");
            return con;
        } catch(Exception e){System.out.println(e);}
            System.err.println("Erro ao conectar!");
            return null;
    }*/
}