/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import java.sql.ResultSet;
import Connection.Conexao;
import Model.bean.Alunos;
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
public class AlunosDao {
 
    public ResultSet loadAlunos(){

        Conexao conn = new Conexao();

        ResultSet  rs = conn.select(" SELECT * FROM alunos");

        return rs;
        
    }
    
    public ResultSet loadSearch(Alunos alunos){

        Conexao conn = new Conexao();
        String addQuery = "";  

        if(!alunos.getNome().equals("Nome") && !alunos.getNome().equals("")){

            addQuery += " AND alun_nome LIKE '%" + alunos.getNome().trim()+"%'";

        }
        if(!alunos.getCpf().equals("CPF") && !alunos.getCpf().equals("")){

            addQuery += " AND alun_cpf =  '" + alunos.getCpf().trim()+"'";

        }
        if(!alunos.getEndereco().equals("Endereço") && !alunos.getEndereco().equals("")){

            addQuery += " AND alun_endereco LIKE '%" + alunos.getEndereco().trim()+"%'";

        }
        if(!alunos.getTelefone().equals("Telefone") && !alunos.getTelefone().equals("") ){

            addQuery += " AND alun_telefone = " + alunos.getTelefone().trim();

        }
        /*if (alunos.getMensalidade() > 0){

            addQuery += " AND alun_mensalidade = " + alunos.getMensalidade();

        }*/
        if(alunos.getMultaAtraso() != 0.00){

            addQuery += " AND alun_multa = " + alunos.getMultaAtraso();

        }
        if(alunos.getIdade() > 0 ){

            addQuery += " AND alun_idade = " + alunos.getIdade();

        }

        ResultSet rs = conn.select(" SELECT * FROM alunos WHERE alun_status != 'off' "+addQuery);

        return rs;

        
    }
    
    
    public void addAluno(Alunos aluno) throws Exception{
  
        Conexao conn = new Conexao();
        
        String erro = "";
        
        if(aluno.getNome().equals("Nome") || aluno.getNome().equals("")){

           erro += "Digite um nome, ";   
           
        }
        
        if(aluno.getCpf().equals("CPF") || aluno.getCpf().equals("")){

           erro += "Digite um CPF, ";

        }
        if(aluno.getEndereco().equals("")){

           erro += "Digite um endereço, ";

        }
        if(aluno.getTelefone().equals("Telefone") || aluno.getTelefone().equals("") ){

           erro += "Digite um Telefone ";

        }
        
        
        System.out.println(erro);
        
        if(!erro.equals("")){
            
            JOptionPane.showMessageDialog(null, "Erro no cadastro: " + erro);
            
        }else{
        
            try{
            
                conn.query("INSERT INTO alunos VALUES (DEFAULT,'"+ aluno.getNome() +"','"+aluno.getCpf()+"','"+aluno.getIdade()+"','"+aluno.getMensalidade()+"',NULL,'"+ aluno.getEndereco()+"','"+aluno.getTelefone()+"','on')");
                JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
            
            }catch(Exception ex){

               JOptionPane.showMessageDialog(null, "Erro no cadastro!");

            }
        
        }
        
    
    }
    
    public void updateAluno(Alunos aluno,int id){
    
        Conexao conn = new Conexao();
        
        try{
            
            conn.query("UPDATE alunos SET alun_nome = '"+ aluno.getNome() +"', alun_cpf =  '"+aluno.getCpf()+"', alun_idade =  '"+aluno.getIdade()+"', alun_mensalidade =  '"+aluno.getMensalidade()+"', alun_multa =  '"+aluno.getMultaAtraso()+"', alun_endereco = '"+ aluno.getEndereco()+"', alun_telefone = '"+aluno.getTelefone()+"' WHERE alun_id = " + id);
            JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso!");
            
        }catch(Exception ex){
            
           JOptionPane.showMessageDialog(null, "Erro na atualização!");
            
        }
        
    
    }
     
    
}
