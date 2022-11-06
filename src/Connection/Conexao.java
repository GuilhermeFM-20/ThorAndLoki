/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Guilherme Freire
 */
public class Conexao {

    private Connection conn = null;
    
    public void myData(){
        
        this.getConnection();
        
    }

    public Connection getConnection() {
        
        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {

            System.out.println("Driver não encotrado.");

        }
        
        try {
           
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotecasbac", "root", "");

            System.out.println("Conexão bem sucedida!");
            
            return conn;

        } catch (SQLException e) {

            System.out.println("Conexão mal sucedida!" + e.getMessage());
                 
        }
        
        return null;

    }

    public void closeConnection() {
        
        if (conn != null) {

            try {

                conn.close();

            } catch (SQLException e) {

                System.out.println("Erro no fechamento da conexão: " + e.getMessage());

            }

        }
        
    }

    public ResultSet query(String rawQuery) {
        
        this.getConnection();
            
        try {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(rawQuery);

            return rs;

        } catch (SQLException e) {

            System.out.println("Erro na consulta das informações:" + e.getMessage());

        }
            
        return null;
        
    }
    
    public void save(String rawQuery) {
        
        this.getConnection();

        try {

            Statement stmt = conn.createStatement();
            stmt.execute(rawQuery);


        } catch (SQLException e) {

            System.out.println("Erro na inserção das informações: " + e.getMessage());

        }
        
    }
     
    public int numRows(String rawQuery) {
        
        this.getConnection();
             
        int i = 0;

        try {

           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(rawQuery);

           while(rs.next()){

               i++;

           }

        } catch (SQLException e) {

            System.out.println("Erro na consulta das informações:" + e.getMessage());

        }
        
        return i;

    }
     
  
}
