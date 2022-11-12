/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import java.sql.ResultSet;
import Connection.Conexao;

/**
 *
 * @author Guilherme Freire
 */
public class PessoasDao {
 
    public ResultSet loadPessoas(){

            
            Conexao conn = new Conexao();

            ResultSet  rs = conn.select(" SELECT * FROM alunos");
            
            return rs;
        
    }
    
    
  
    
}
