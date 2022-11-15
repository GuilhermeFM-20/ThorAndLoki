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
        
        System.out.println("entrou");
    
    
        Conexao conn = new Conexao();
        String addQuerry = "";
    
        if (!professores.getNome().equals("Nome") && !professores.getNome().equals("")){
        
            addQuerry += "AND prof_nome LIKE '%" + professores.getNome().trim() + "'%";
        
        }
        if (!professores.getCpf().equals("CPF") && !professores.getCpf().equals("")){
        
            addQuerry += "AND prof_cpf LIKE '%" + professores.getCpf().trim() + "'%";
        
        }
        if (!professores.getEndereco().equals("Endereço") && !professores.getEndereco().equals("")){
        
            addQuerry += "AND prof_endereco LIKE '%" + professores.getEndereco().trim() + "'%";
        
        }
        if (!professores.getTelefone().equals("Telefone") && !professores.getTelefone().equals("")){
        
            addQuerry += "AND prof_telefone LIKE '%" + professores.getNome().trim() + "'%";
            
        }
        if (!professores.getSalario().equals("Salário") && !professores.getSalario().equals("")){
        
            addQuerry += "AND prof_salario LIKE '%" + professores.getSalario().trim() + "'%";
        
        }
        if (!professores.getHoras_trab().equals("Horas de Trabalho") && !professores.getHoras_trab().equals("")){
        
            addQuerry += "AND prof_horas LIKE '%" + professores.getHoras_trab().trim() + "'%";
        
        }
        
        ResultSet rs = conn.select(" SELECT * FROM alunos WHERE prof_status != 'off' " + addQuerry);
    
        return rs;
    
    
    }
    
}
