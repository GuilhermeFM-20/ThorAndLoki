/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import java.sql.ResultSet;
import Connection.Conexao;
import Model.bean.Funcionarios;
import Model.bean.Pessoas;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Guilherme Freire
 */
public class FuncionariosDao {
 
    public ResultSet loadFuncionarios(){

        Conexao conn = new Conexao();

        ResultSet  rs = conn.select(" SELECT * FROM funcionario");

        return rs;
        
    }
    
    public ResultSet loadSearch(Funcionarios funcionarios){
        
        
        
        
        Conexao conn = new Conexao();
        String addQuery = "";  

        if(!funcionarios.getNome().equals("Nome") && !funcionarios.getNome().equals("")){

            addQuery += " AND func_nome LIKE '%" + funcionarios.getNome().trim()+"%'";

        }
        
        if(!funcionarios.getEndereco().equals("Endereço") && !funcionarios.getEndereco().equals("")){

            addQuery += " AND func_endereco LIKE '%" + funcionarios.getEndereco().trim()+"%'";

        }
        if(!funcionarios.getTelefone().equals("Telefone") && !funcionarios.getTelefone().equals("") ){

            addQuery += " AND func_telefone = '" + funcionarios.getTelefone() + "'";

        }

        ResultSet rs = conn.select(" SELECT * FROM funcionario WHERE func_status != 'off' "+addQuery);

        return rs;

        
    }
    
    
    public void addFuncionarios(Funcionarios funcionario) throws Exception{
        
        
    
        Conexao conn = new Conexao();
        
        String erro = "";
        
        if(funcionario.getNome().equals("Nome") || funcionario.getNome().equals("")){

           erro += "Digite um nome, ";   
           
        }
        
        if(funcionario.getEndereco().equals("Endereço") || funcionario.getEndereco().equals("")){

           erro += "Digite um endereço, ";

        }
        if(funcionario.getTelefone().equals("Telefone") || funcionario.getTelefone().equals("") ){

           erro += "Digite um Telefone ";

        }
        
        
        System.out.println(erro);
        
        if(!erro.equals("")){
            
            JOptionPane.showMessageDialog(null, "Erro no cadastro: " + erro);
            
        }else{
        
            try{
            
                conn.query("INSERT INTO funcionario VALUES (DEFAULT,'"+ funcionario.getNome() +"',"+funcionario.getSalario()+",'"+ funcionario.getFuncao()+"','"+funcionario.getEndereco()+"','"+funcionario.getTelefone()+"','on')");
                JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso!");
            
            }catch(Exception ex){

               JOptionPane.showMessageDialog(null, "Erro no cadastro!");

            }
        
        }
        
    
    }
    
    public void updateFuncionario(Funcionarios funcionario,int id){
    
        Conexao conn = new Conexao();
        
        try{
            
            conn.query("UPDATE funcionario SET func_nome = '"+ funcionario.getNome() +"', func_funcao =  '"+funcionario.getFuncao()+"', func_endereco = '"+ funcionario.getEndereco()+"', func_telefone = '"+funcionario.getTelefone()+"', func_salario = '"+funcionario.getSalario()+"' WHERE func_id = " + id);
            JOptionPane.showMessageDialog(null, "Funcionario atualizado com sucesso!");
            
        }catch(Exception ex){
            
           JOptionPane.showMessageDialog(null, "Erro na atualização!");
            
        }
        
    
    }
     
    
}
