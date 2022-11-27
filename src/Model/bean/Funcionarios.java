/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.bean;

import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class Funcionarios extends Pessoas{
    private float salario;
    private String funcao;
    
    public Funcionarios(String funcao, float salario, String nome, String cpf, String endereco, String telefone){
        super(nome, cpf, endereco, telefone);
        
        this.setSalario(salario);
        this.setFuncao(funcao);
    
    }
    public float getSalario(){
        return salario;
    }


    public void setSalario(float salario) {
        
            this.salario = salario;
        
    }
    
    public String getFuncao(){
        return funcao;
}
    
    public void setFuncao(String funcao){
        this.funcao = funcao;
}
    
}
