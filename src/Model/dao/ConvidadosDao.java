/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import java.sql.ResultSet;
import Connection.Conexao;
import Model.bean.Convidados;
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
public class ConvidadosDao {
 
    public ResultSet loadConvidados(){

        Conexao conn = new Conexao();

        ResultSet  rs = conn.select(" SELECT * FROM convidados");

        return rs;
        
    }
    
    public ResultSet loadSearch(Convidados convidado){
        
        System.out.println("Entrou");
        
        
        Conexao conn = new Conexao();
        String addQuery = "";  

        if(!convidado.getNome().equals("Nome") && !convidado.getNome().equals("")){

            addQuery += " AND conv_nome LIKE '%" + convidado.getNome().trim()+"%'";

        }
        if(!convidado.getCpf().equals("CPF") && !convidado.getCpf().equals("")){

            addQuery += " AND conv_cpf =  '" + convidado.getCpf().trim()+"'";

        }
        if(!(convidado.getValor() > 0)){

            addQuery += " AND conv_valor = " + convidado.getValor();

        }

        ResultSet rs = conn.select(" SELECT * FROM convidados WHERE conv_status != 'off' "+addQuery);

        return rs;

        
    }
    
    
    public void addConvidado(Convidados convidado) throws Exception{
        
        
    
        Conexao conn = new Conexao();
        
        String erro = "";
        
        if(convidado.getNome().equals("Nome") || convidado.getNome().equals("")){

           erro += "Digite um nome, ";   
           
        }
        
        if(convidado.getCpf().equals("CPF") || convidado.getCpf().equals("")){

           erro += "Digite um CPF, ";

        }
        if(convidado.getValor() > 0){

           erro += "Digite um valor, ";

        }
     
        
        
        System.out.println(erro);
        
        if(!erro.equals("")){
            
            JOptionPane.showMessageDialog(null, "Erro no cadastro: " + erro);
            
        }else{
        
            try{
            
                conn.query("INSERT INTO convidados VALUES (DEFAULT,'"+ convidado.getNome() +"','"+convidado.getCpf()+"','"+ convidado.getValor() +",on)");
                JOptionPane.showMessageDialog(null, "Convidado cadastrado com sucesso!");
            
            }catch(Exception ex){

               JOptionPane.showMessageDialog(null, "Erro no cadastro!");

            }
        
        }
        
    
    }
    
    public void updateConvidado(Convidados convidado,int id){
    
        Conexao conn = new Conexao();
        
        try{
            
            conn.query("UPDATE convidados SET conv_nome = '"+ convidado.getNome() +"', conv_cpf =  '"+convidado.getCpf()+"', conv_endereco = '"+ convidado.getValor() +",on");
            JOptionPane.showMessageDialog(null, "Convidado atualizado com sucesso!");
            
        }catch(Exception ex){
            
           JOptionPane.showMessageDialog(null, "Erro na atualização!");
            
        }
        
    
    }
     
    
}
