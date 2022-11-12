/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import java.sql.ResultSet;
import Connection.Conexao;
import Model.bean.Pessoas;
import java.sql.SQLException;

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
    
    public ResultSet loadSearch(Pessoas pessoas){
        
        System.out.println("Entrou");
        
        
        Conexao conn = new Conexao();
        String addQuery = "";  

        if(!pessoas.getNome().equals("Nome") && !pessoas.getNome().equals("")){

            addQuery += " AND alun_nome LIKE '%" + pessoas.getNome().trim()+"%'";

        }
        if(!pessoas.getCpf().equals("CPF") && !pessoas.getCpf().equals("")){

            addQuery += " AND alun_cpf =  '" + pessoas.getCpf().trim()+"'";

        }
        if(!pessoas.getEndereco().equals("Endereço") && !pessoas.getEndereco().equals("")){

            addQuery += " AND alun_endereco LIKE '%" + pessoas.getEndereco().trim()+"%'";

        }
        if(!pessoas.getTelefone().equals("Telefone") && !pessoas.getTelefone().equals("") ){

            addQuery += " AND alun_telefone = " + pessoas.getTelefone().trim();

        }

        ResultSet rs = conn.select(" SELECT * FROM alunos WHERE alun_status != 'off' "+addQuery);

        return rs;

        
    }
    
    
    
  
    
}
