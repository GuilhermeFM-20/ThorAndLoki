/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import java.sql.ResultSet;
import Connection.Conexao;
import Model.bean.Professores;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class ProfessoresDao {
    
    public ResultSet loadProfessores(){

        Conexao conn = new Conexao();

        ResultSet  rs = conn.select(" SELECT * FROM professores");

        return rs;
        
    }
    
    public ResultSet loadSearch(Professores professores){
       
    
        Conexao conn = new Conexao();
        String addQuery = "";
    
        if (!professores.getNome().equals("Nome") && !professores.getNome().equals("")){
        
            addQuery += "AND prof_nome LIKE '%" + professores.getNome().trim() + "%'";
        
        }
        if (!professores.getCpf().equals("CPF") && !professores.getCpf().equals("")){
        
            addQuery += "AND prof_cpf LIKE '%" + professores.getCpf().trim() + "%'";
        
        }
        if (!professores.getEndereco().equals("Endereço") && !professores.getEndereco().equals("")){
        
            addQuery += "AND prof_endereco LIKE '%" + professores.getEndereco().trim() + "%'";
        
        }
        if (!professores.getTelefone().equals("Telefone") && !professores.getTelefone().equals("")){
        
            addQuery += "AND prof_telefone LIKE '%" + professores.getTelefone() + "%'";
            
        }
        if (professores.getSalario() != 0.00){
        
            addQuery += "AND prof_salario = " + professores.getSalario();
        
        }
        if (!professores.getHoras_trab().equals("Horas") && !professores.getHoras_trab().equals("")){
        
            addQuery += "AND prof_horas LIKE '%" + professores.getHoras_trab() + "%'";
        
        }
        
        ResultSet rs = conn.select(" SELECT * FROM professores WHERE prof_status != 'off' " + addQuery);

        return rs;
    
    }
   
    public void addProfessores(Professores professores){
            
            
        
        Conexao conn = new Conexao();
            
        String erro = "";
            
        if(professores.getNome().equals("Nome") || (professores.getNome().equals(""))){
            erro += "Digite um nome, ";
                
        }
        if(professores.getCpf().equals("CPF") || (professores.getCpf().equals(""))){
            erro += "Digite um CPF, ";
                
        }
        if(professores.getEndereco().equals("Endereço") || (professores.getEndereco().equals(""))){
            erro += "Digite um endereço, ";
                
        }
        if(professores.getTelefone().equals("Telefone") || (professores.getTelefone().equals(""))){
            erro += "Digite um Telefone, ";
                
        }
        if(professores.getHoras_trab().equals("Horas de trabalho") || (professores.getHoras_trab().equals(""))){
            erro += "Digite as horas de trabalho, ";
                
        }

        if (professores.getSalario() <= 0.00){
            erro += "Digite o salário, ";

        }
            
        System.out.println(erro);
            
        if(!erro.equals("")){
            JOptionPane.showMessageDialog(null, "Erro no cadastro: " + erro);
                
        }else{
                
            try{
                    
                conn.query("INSERT INTO professores VALUES (DEFAULT,'"+ professores.getNome() +"','"+professores.getCpf()+"',"+ professores.getSalario()+",'"+professores.getEndereco()+"','"+professores.getTelefone()+"','"+professores.getHoras_trab()+"','on')");
                JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso");
                    
            }catch(Exception ex){
                    
                JOptionPane.showMessageDialog(null, "Erro no cadastro");
                    
            }
            
            
        }
               
            
    }
    
    public void updateProfessores(Professores professores,int id){
        
        Conexao conn = new Conexao();
        
        try{
            
            conn.query("UPDATE professores SET prof_nome = '"+ professores.getNome() +"', prof_cpf =  '"+professores.getCpf()+"', prof_endereco = '"+ professores.getEndereco()+"', prof_telefone = '"+professores.getTelefone()+"', prof_salario = '"+professores.getSalario()+"', prof_horas = '"+professores.getHoras_trab()+"' WHERE prof_id = " + id);
            
        }
        catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, "Erro na atualização");
            
        }
        
        
    }
    
    
}
